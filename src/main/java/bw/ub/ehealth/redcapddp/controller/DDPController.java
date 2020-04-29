package bw.ub.ehealth.redcapddp.controller;

import bw.ub.ehealth.redcapddp.model.Patient;
import bw.ub.ehealth.redcapddp.service.MetadataService;
import bw.ub.ehealth.redcapddp.service.PatientService;
import bw.ub.ehealth.redcapddp.service.RedcapConfigService;
import bw.ub.ehealth.redcapddp.service.UserRightService;
import bw.ub.ehealth.redcapddp.vo.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@RestController
@RequestMapping("/ddpcontroller")
public class DDPController {

    private Logger logger = LoggerFactory.getLogger(DDPController.class);

    @Value("${dhis2.api.url}")
    private String dhis2Url;

    @Value("${dhis2.api.program}")
    private String program;

    @Value("${dhis2.api.program.stage}")
    private String programStage;

    @Autowired
    private RedcapConfigService redcapConfigService;

    @Autowired
    private UserRightService userRightService;

    @Autowired
    private MetadataService metadataService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DhisLink dhisLink;

    private Set<MetadataVO> createPatientSpecimenMetadata() {

        ObjectMapper mapper = new ObjectMapper();
        try {
            TypeReference<Set<MetadataVO>> typeReference = new TypeReference<Set<MetadataVO>>() {
            };

            Set<MetadataVO> s = mapper.readValue(new File("/home/junior/programming/work/redcapddp/ddp_patient_metadata_service.txt"), typeReference);

            logger.info(s.toString());

            s.forEach(m -> m.setProjectId(14L));
            s.forEach(m -> metadataService.saveMetadata(m));

            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/getdhisuser")
    @ResponseBody
    public CurrentUser getDhisUser() {
        return dhisLink.getCurrentUser();
    }

    @GetMapping(value = "/events")
    public List<Event> getEvents() {

        Map<String, String> params = new HashMap<>();
        params.put("program", program);
        params.put("programStage", programStage);
        params.put("startDate", "2020-04-29");
        params.put("order", "eventDate:asc");
        params.put("pageSize", "50");

        int page = 1;
        params.put("page", "" + page);
        List<Event> allEvents = new ArrayList<>();
        List<Event> tmp = dhisLink.getEvents(params);

        while(tmp != null && tmp.size() > 0) {
            logger.info("Page " + page + " has " + tmp.size() + " events.");
            allEvents.addAll(tmp);
            page++;
            params.put("page", "" + page);
            tmp = dhisLink.getEvents(params);
        }

        return allEvents;
    }

    @GetMapping(value = "/newspecimen")
    @ResponseBody
    public List<SpecimenVO> getSpecimen() {
        Map<String, String> params = new HashMap<>();
        params.put("program", program);
        params.put("programStage", programStage);
        params.put("startDate", "2020-04-29");
        params.put("order", "eventDate:asc");
        params.put("pageSize", "50");

        int page = 1;
        params.put("page", "" + page);
        List<SpecimenVO> specimen = new ArrayList<>();

        specimen = dhisLink.getSpecimen(params);

        return specimen;
    }

    @GetMapping(value = "/program")
    @ResponseBody
    public Program getProgram() {

        return dhisLink.getProgram(program);
    }



    /*
    @GetMapping(value = "/trackedentityinstance")
    public TrackedEntityInstance getTrackedEntityInstance() {
        String append = "/trackedEntityInstances?ou=Ywjmoc1xeje&trackedEntityInstance=ky2j0V6wJJi";
        TrackedEntityInstance instance = restTemplate().getForObject(dhis2Url + append, TrackedEntityInstance.class);
        return instance;
    }

    @GetMapping(value = "/programStage")
    @ResponseBody
    public ProgramStage getProgramStage() {
        ProgramStage stage = restTemplate().getForObject(dhis2Url + "/programStages/" + programStage, ProgramStage.class);
        return stage;
    }

    @GetMapping(value = "/programStages")
    @ResponseBody
    public List<ProgramStage> getProgramStages() {
        ProgramStageList stages = restTemplate().getForObject(dhis2Url + "/programStages/", ProgramStageList.class);
        return stages.getProgramStages();
    }

    @GetMapping(value = "/organisationUnit")
    @ResponseBody
    public OrganisationUnit getOrganisationUnit() {
        return restTemplate().getForObject(dhis2Url + "/organisationUnits/zwts3rCXPDU", OrganisationUnit.class);
    }*/

    @GetMapping("/initpro14metadata")
    public Set<MetadataVO> initialiseProject14() {
        return createPatientSpecimenMetadata();
    }

    @GetMapping("/initdemometadata")
    public Set<MetadataVO> initialiseDemoProject() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            TypeReference<Set<MetadataVO>> typeReference = new TypeReference<Set<MetadataVO>>() {
            };

            Set<MetadataVO> s = mapper.readValue(new File("/home/junior/programming/work/redcapddp/ddp_patient_metadata_service.txt"), typeReference);

            logger.info(s.toString());

            s.forEach(m -> m.setProjectId(14L));
            s.forEach(m -> metadataService.saveMetadata(m));

            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/metadata")
    @ResponseBody
    public Set<MetadataVO> getMetadataService(@RequestBody PostRequestObject postRequestObject) {
        Set<MetadataVO> meta = metadataService.findProjectMetadata(Long.parseLong(postRequestObject.getProject_id()));

        logger.info("Found " + meta.size());
        return meta;
    }

    @PostMapping("/patientdata")
    @ResponseBody
    public PatientVO getPatientData(@RequestBody PostRequestObject postRequestObject) {
        UserRightVO userRightVO = userRightService.findUserRight(postRequestObject.getUser(),
                Long.parseLong(postRequestObject.getProject_id()));
        PatientVO patientVO = null;
        if( userRightVO != null) {
             patientVO = patientService.getPatientByIdNumber(postRequestObject.getId());
        }

        return patientVO;
    }

    @PostMapping("/read")
    public void readSourceFile(String source) {

    }
}
