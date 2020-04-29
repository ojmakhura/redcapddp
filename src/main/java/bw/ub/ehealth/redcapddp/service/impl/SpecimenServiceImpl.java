package bw.ub.ehealth.redcapddp.service.impl;

import bw.ub.ehealth.redcapddp.model.Specimen;
import bw.ub.ehealth.redcapddp.repository.PatientRepository;
import bw.ub.ehealth.redcapddp.repository.SpecimenRepository;
import bw.ub.ehealth.redcapddp.service.SpecimenService;
import bw.ub.ehealth.redcapddp.vo.PatientVO;
import bw.ub.ehealth.redcapddp.vo.SpecimenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service("specimenService")
public class SpecimenServiceImpl implements SpecimenService {

    @Autowired
    private SpecimenRepository specimenRepository;

    @Autowired
    private PatientRepository patientRepository;

    public Specimen toSpecimenEntity(SpecimenVO specimenVO) {

        Specimen specimen;

        if(specimenVO.getId() == null) {
            specimen = Specimen.instance();
        } else {
            specimen = specimenRepository.getOne(specimenVO.getId());
        }

        specimen.setBatchNumber(specimenVO.getBatchNumber());
        specimen.setCollectionDateTime(specimenVO.getCollectionDateTime());
        specimen.setDispatchedDateTime(specimenVO.getDispatchedDateTime());
        specimen.setDispatcher(specimenVO.getDispatcher());
        specimen.setDispatchLocation(specimenVO.getDispatchLocation());
        specimen.setLocationDetails(specimenVO.getLocationDetails());
        specimen.setLatitude(specimenVO.getLatitude());
        specimen.setLongitude(specimenVO.getLongitude());
        specimen.setSampleStatus(specimenVO.getSampleStatus());

        if(specimen.getPatient() != null && specimenVO.getPatientVO() != null &&
                (specimenVO.getPatientVO().getId() != specimen.getPatient().getId())) {
            specimen.setPatient(patientRepository.getOne(specimenVO.getPatientVO().getId()));
        }

        return specimen;
    }

    public SpecimenVO toSpecimenVO(Specimen specimen) {

        SpecimenVO specimenVO = new SpecimenVO();

        specimenVO.setBatchNumber(specimenVO.getBatchNumber());
        specimenVO.setCollectionDateTime(specimenVO.getCollectionDateTime());
        specimenVO.setDispatchedDateTime(specimenVO.getDispatchedDateTime());
        specimenVO.setDispatcher(specimenVO.getDispatcher());
        specimenVO.setDispatchLocation(specimenVO.getDispatchLocation());
        specimenVO.setLocationDetails(specimenVO.getLocationDetails());
        specimenVO.setLatitude(specimenVO.getLatitude());
        specimenVO.setLongitude(specimenVO.getLongitude());
        specimenVO.setSampleStatus(specimenVO.getSampleStatus());

        if(specimenVO.getPatientVO() != null && specimen.getPatient() != null &&
                (specimenVO.getPatientVO().getId() != specimen.getPatient().getId())) {
            PatientVO patientVO = new PatientVO();
            patientVO.setContactNumber(specimen.getPatient().getContactNumber());
            patientVO.setDob(specimen.getPatient().getDob());
            patientVO.setFirstName(specimen.getPatient().getFirstName());
            patientVO.setId(specimen.getPatient().getId());
            patientVO.setIdNumber(specimen.getPatient().getIdNumber());
            patientVO.setSex(specimen.getPatient().getSex());
            patientVO.setSurname(specimen.getPatient().getSurname());
            specimenVO.setPatientVO(patientVO);
        }

        return specimenVO;
    }

    @Override
    @Transactional
    public Set<SpecimenVO> findPatientSpecimen(PatientVO patientVO) {

        Set<SpecimenVO> specimenVOS = new HashSet<>();
        return specimenVOS;
    }
}
