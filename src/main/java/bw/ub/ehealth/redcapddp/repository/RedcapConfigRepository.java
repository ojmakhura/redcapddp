package bw.ub.ehealth.redcapddp.repository;

import bw.ub.ehealth.redcapddp.model.RedcapConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RedcapConfigRepository extends JpaRepository<RedcapConfig, Long> {

    @Query("SELECT U FROM bw.ub.ehealth.redcapddp.model.RedcapConfig U WHERE U.value = :url")
    RedcapConfig getConfigByURL(@Param("url") String url);

    @Query("SELECT U FROM bw.ub.ehealth.redcapddp.model.RedcapConfig U WHERE U.fieldName = :fieldName")
    RedcapConfig getConfigFieldName(@Param("fieldName") String fieldName);
}
