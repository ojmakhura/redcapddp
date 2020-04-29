package bw.ub.ehealth.redcapddp.controller;

import bw.ub.ehealth.redcapddp.service.PatientService;
import bw.ub.ehealth.redcapddp.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class DhisLink implements Serializable {

    private Logger logger = LoggerFactory.getLogger(DhisLink.class);

    private CurrentUser currentUser = null;

    @Autowired
    private RestTemplateBuilder builder;

    @Value("${dhis2.api.url}")
    private String dhis2Url;

    @Autowired
    private PatientService patientService;

    public DhisLink() {

    }

    @Bean
    public RestTemplate restTemplate() {
        return builder.basicAuthentication("demo", "Demo@2020").build();
    }

    public CurrentUser getCurrentUser() {

        currentUser = restTemplate().getForObject(dhis2Url + "/me", CurrentUser.class);
        return currentUser;
    }

    public List<Event> getEvents(Map<String, String> parameters) {
        StringBuilder builder = new StringBuilder();

        for(Map.Entry<String, String> entry : parameters.entrySet()) {
            if(builder.length() > 0) {
                builder.append("&");
            }
            builder.append(entry.getKey() + "=" + entry.getValue());
        }
        String finalUrl = dhis2Url + "/events?" + builder.toString();
        logger.info("Final URL is " + finalUrl);

        EventList eventList = restTemplate().getForObject(finalUrl, EventList.class);
        logger.info("Found " + eventList.getEvents().size() + " events.");
        return eventList.getEvents();
    }

    public Program getProgram(String program) {

        return restTemplate().getForObject(dhis2Url + "/programs/" + program, Program.class);
    }

    public TrackedEntityInstance getTrackedEntityInstance(@NotBlank String orgUnit, @NotBlank String instanceId) {

        String append = "/trackedEntityInstances?ou=" + orgUnit + "&trackedEntityInstance=" + instanceId;
        return restTemplate().getForObject(dhis2Url + append, TrackedEntityInstance.class);
    }

    private PatientVO trackedEntityInstanceToPatientVO(TrackedEntityInstance trackedEntityInstance) {
        PatientVO patientVO = null;

        Map<String, TrackedEntityInstanceAttribute> attrMap = getTrackedEntityInstanceAttributeMap(trackedEntityInstance.getAttributes());
        if(attrMap.containsKey("Omang")) {
            patientService.getPatientByIdNumber(attrMap.get("Omang").getValue());
        } else if(attrMap.containsKey("Passport No")) {
            patientService.getPatientByIdNumber(attrMap.get("Passport No").getValue());
        }

        // We did not find the patient information in the Redcap database
        if(patientVO == null) {
            patientVO = new PatientVO();
            patientVO.setIdNumber(attrMap.get("Omang").getValue());

            if(patientVO.getIdNumber() == null) {
                patientVO.setIdNumber(attrMap.get("Passport No").getValue());
            }

            patientVO.setSurname(attrMap.get("Surname").getValue());
            patientVO.setFirstName(attrMap.get("Name").getValue());

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            try {
                patientVO.setDob(format.parse(attrMap.get("Date of birth").getValue()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            patientVO.setContactNumber(attrMap.get("Telephone").getValue());
        }

        return patientVO;
    }

    private Map<String, TrackedEntityInstanceAttribute> getTrackedEntityInstanceAttributeMap(List<TrackedEntityInstanceAttribute> attributes) {

        Map<String, TrackedEntityInstanceAttribute> attr = new HashMap<>();

        for(TrackedEntityInstanceAttribute a : attributes) {
            attr.put(a.getDisplayName(), a);
        }

        return attr;
    }

    /**
     * We need to convert an event into a SpecimenVO. To do this, we must first get a
     * TrackedEntityInstance to find the PatientVO. This can be done by getting the
     * PatientVO from the Redcap side if it already existed or by creating a new one
     * based on the information contained in the TrackedEntityInstance
     *
     * @param event
     * @return
     */
    private SpecimenVO eventToSpecimen(Event event) {

        TrackedEntityInstance instance = getTrackedEntityInstance(event.getOrgUnit(), event.getTrackedEntityInstance());
        PatientVO patientVO = trackedEntityInstanceToPatientVO(instance);

        // The patient is a new one
        if(patientVO.getId() == null) {
            patientVO = patientService.savePatient(patientVO);
        }

        SpecimenVO specimen = new SpecimenVO();
        specimen.setPatientVO(patientVO);

        return specimen;
    }

    public List<SpecimenVO> getSpecimen(Map<String, String> parameters) {


        List<Event> events = this.getEvents(parameters);

        List<SpecimenVO> specimen = new ArrayList<>();

        return specimen;
    }

}
