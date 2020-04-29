package bw.ub.ehealth.redcapddp.service;

import bw.ub.ehealth.redcapddp.vo.PatientVO;

public interface PatientService {

    PatientVO getPatientById(Long id);

    PatientVO getPatientByIdNumber(String idNUmber);

    PatientVO savePatient(PatientVO patientVO);
}
