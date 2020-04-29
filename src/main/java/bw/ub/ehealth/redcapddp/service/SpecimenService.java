package bw.ub.ehealth.redcapddp.service;

import bw.ub.ehealth.redcapddp.vo.PatientVO;
import bw.ub.ehealth.redcapddp.vo.SpecimenVO;

import java.util.Set;

public interface SpecimenService {

    Set<SpecimenVO> findPatientSpecimen(PatientVO patientVO);

}
