package bw.ub.ehealth.redcapddp.service.impl;

import bw.ub.ehealth.redcapddp.model.RedcapConfig;
import bw.ub.ehealth.redcapddp.repository.RedcapConfigRepository;
import bw.ub.ehealth.redcapddp.service.RedcapConfigService;
import bw.ub.ehealth.redcapddp.vo.RedcapConfigVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;

@Service("redcapConfigService")
public class RedcapConfigServiceImpl implements RedcapConfigService {

    @Autowired
    private RedcapConfigRepository redcapConfigRepository;

    public RedcapConfigVO toRedcapConfigVO(@NotNull RedcapConfig redcapConfig) {

        RedcapConfigVO redcapConfigVO = new RedcapConfigVO();

        redcapConfigVO.setFieldName(redcapConfig.getFieldName());
        redcapConfigVO.setValue(redcapConfig.getValue());

        return redcapConfigVO;
    }

    public RedcapConfig toRedcapConfigEntity(@NotNull RedcapConfigVO redcapConfigVO) {

        if(StringUtils.isEmpty(redcapConfigVO.getValue()) || StringUtils.isEmpty(redcapConfigVO.getFieldName())) {
            return null;
        }
       return new RedcapConfig(redcapConfigVO.getFieldName(), redcapConfigVO.getValue());
    }

    @Override
    @Transactional
    public RedcapConfigVO getConfigURL() {
        return toRedcapConfigVO(redcapConfigRepository.getConfigFieldName("redcap_base_url"));
    }
}
