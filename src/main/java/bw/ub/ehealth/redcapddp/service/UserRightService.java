package bw.ub.ehealth.redcapddp.service;

import bw.ub.ehealth.redcapddp.vo.UserRightVO;

public interface UserRightService {

    UserRightVO findUserRight(String username, Long projectId);
}
