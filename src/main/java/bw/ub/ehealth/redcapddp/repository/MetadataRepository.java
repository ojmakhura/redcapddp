package bw.ub.ehealth.redcapddp.repository;

import bw.ub.ehealth.redcapddp.model.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface MetadataRepository extends JpaRepository<Metadata, Long> {

    @Query("SELECT m FROM bw.ub.ehealth.redcapddp.model.Metadata m WHERE m.projectId = :projectId")
    Set<Metadata> findProjectMetadata(@Param("projectId") Long projectId);

}
