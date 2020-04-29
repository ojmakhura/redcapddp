package bw.ub.ehealth.redcapddp.repository;

import bw.ub.ehealth.redcapddp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
