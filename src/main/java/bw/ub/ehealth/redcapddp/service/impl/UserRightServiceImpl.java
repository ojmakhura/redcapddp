package bw.ub.ehealth.redcapddp.service.impl;

import bw.ub.ehealth.redcapddp.model.Specimen;
import bw.ub.ehealth.redcapddp.model.UserRight;
import bw.ub.ehealth.redcapddp.repository.UserRightRepository;
import bw.ub.ehealth.redcapddp.service.UserRightService;
import bw.ub.ehealth.redcapddp.vo.UserRightVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Service("userRightService")
public class UserRightServiceImpl implements UserRightService {

    @Autowired
    private UserRightRepository userRightRepository;

    public UserRightVO toUserRightVO(@NotNull UserRight userRight) {
        UserRightVO userRightVO = new UserRightVO(
                userRight.getId(),
                userRight.getProjectId(),
                userRight.getUsername(),
                userRight.getRoleId(),
                userRight.getGroupId()
                );

        return userRightVO;
    }

    public UserRight toUserRightEntity(@NotNull UserRightVO userRightVO) {

        UserRight userRight = null;

        if(userRightVO.getId() != null ) {
            userRight = userRightRepository.getOne(userRightVO.getId());
        } else {
            userRight = new UserRight();
        }

        userRight.setId(userRightVO.getId());
        userRight.setGroupId(userRightVO.getGroupId());
        userRight.setProjectId(userRightVO.getProjectId());
        userRight.setRoleId(userRightVO.getRoleId());
        userRight.setUsername(userRightVO.getUsername());

        return userRight;
    }

    @Override
    @Transactional
    public UserRightVO findUserRight(String username, Long projectId) {
        return toUserRightVO(userRightRepository.findUserRight(username, projectId));
    }
}
