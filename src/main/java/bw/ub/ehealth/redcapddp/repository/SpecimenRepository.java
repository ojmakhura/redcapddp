package bw.ub.ehealth.redcapddp.repository;

import bw.ub.ehealth.redcapddp.model.Patient;
import bw.ub.ehealth.redcapddp.model.Specimen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface SpecimenRepository extends JpaRepository<Specimen, Long> {

    @Query("SELECT s FROM bw.ub.ehealth.redcapddp.model.Specimen s WHERE s.patient.id = :patientId")
    Set<Specimen> findPatientSpecimen(@Param("patientId") Long patientId);
}
