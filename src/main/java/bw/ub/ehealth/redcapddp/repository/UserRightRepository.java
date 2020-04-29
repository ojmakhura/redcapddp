package bw.ub.ehealth.redcapddp.repository;

import bw.ub.ehealth.redcapddp.model.UserRight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRightRepository extends JpaRepository<UserRight, Long> {

    @Query("SELECT R FROM bw.ub.ehealth.redcapddp.model.UserRight R WHERE R.username = :username AND R.projectId = :projectId")
    UserRight findUserRight(@Param("username") String username, @Param("projectId") Long projectId);
}
