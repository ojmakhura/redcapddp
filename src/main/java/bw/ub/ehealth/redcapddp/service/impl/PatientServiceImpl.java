package bw.ub.ehealth.redcapddp.service.impl;

import bw.ub.ehealth.redcapddp.model.Patient;
import bw.ub.ehealth.redcapddp.repository.PatientRepository;
import bw.ub.ehealth.redcapddp.service.PatientService;
import bw.ub.ehealth.redcapddp.service.SpecimenService;
import bw.ub.ehealth.redcapddp.vo.PatientVO;
import bw.ub.ehealth.redcapddp.vo.SpecimenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.HashSet;

@Service("patientService")
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SpecimenService specimenService;

    public Patient toPatientEntity(@NotNull PatientVO patientVO) {

        Patient patient = null;

        if(patientVO.getId() != null) {
            patientRepository.getOne(patientVO.getId());
        } else {
            patient = Patient.instance();
        }

        patient.setContactNumber(patientVO.getContactNumber());
        patient.setDob(patientVO.getDob());
        patient.setFirstName(patientVO.getFirstName());
        patient.setIdNumber(patientVO.getIdNumber());
        patient.setSex(patientVO.getSex());

        for (SpecimenVO specimenVO : patientVO.getSpecimens()) {
            if(specimenVO.getId() != null) {

            }
        }

        return patient;
    }

    public PatientVO toPatientVO(Patient patient) {

        PatientVO patientVO = new PatientVO();

        patientVO.setContactNumber(patient.getContactNumber());
        patientVO.setDob(patient.getDob());
        patientVO.setFirstName(patient.getFirstName());
        patientVO.setId(patient.getId());
        patientVO.setIdNumber(patient.getIdNumber());
        patientVO.setSex(patient.getSex());
        patientVO.setSurname(patient.getSurname());

        patientVO.setSpecimens(new HashSet<>());

        return patientVO;
    }

    @Override
    @Transactional
    public PatientVO getPatientById(Long id) {
        Patient patient = patientRepository.getOne(id);
        return toPatientVO(patient);
    }

    @Override
    public PatientVO getPatientByIdNumber(String idNUmber) {
        return null;
    }

    @Override
    public PatientVO savePatient(PatientVO patientVO) {
        return toPatientVO(patientRepository.save(toPatientEntity(patientVO)));
    }
}
