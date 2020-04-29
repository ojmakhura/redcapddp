package bw.ub.ehealth.redcapddp.service.impl;

import bw.ub.ehealth.redcapddp.model.Metadata;
import bw.ub.ehealth.redcapddp.repository.MetadataRepository;
import bw.ub.ehealth.redcapddp.service.MetadataService;
import bw.ub.ehealth.redcapddp.vo.MetadataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Service("metadataService")
public class MetadataServiceImpl implements MetadataService {

    @Autowired
    private MetadataRepository metadataRepository;

    public MetadataVO toMetadataVO(@NotNull Metadata metadata) {

        MetadataVO vo = new MetadataVO(
                metadata.getId(),
                metadata.getProjectId(),
                metadata.getField(),
                metadata.getLabel(),
                metadata.getDescription(),
                metadata.getTemporal(),
                metadata.getCategory(),
                metadata.getSubcatergory(),
                metadata.getIdentifier()
        );

        return vo;
    }

    private Metadata toMetadataEntity(@NotNull MetadataVO metadataVO) {

        Metadata metadata = null;

        if (metadataVO.getId() != null) {
            metadata = metadataRepository.getOne(metadataVO.getId());
        } else {
            metadata = new Metadata();
        }

        metadata.setCategory(metadataVO.getCategory());
        metadata.setDescription(metadataVO.getDescription());
        metadata.setField(metadataVO.getField());
        metadata.setIdentifier(metadataVO.getIdentifier());
        metadata.setLabel(metadataVO.getLabel());
        metadata.setProjectId(metadataVO.getProjectId());
        metadata.setSubcatergory(metadataVO.getCategory());
        metadata.setIdentifier(metadataVO.getIdentifier());

        return metadata;
    }

    public Set<MetadataVO> toMetadataVOSet(Set<Metadata> metadataSet) {

        Set<MetadataVO> metadataVOS = new HashSet<>();
        metadataSet.forEach(metadata -> metadataVOS.add(toMetadataVO(metadata)));

        return metadataVOS;
    }

    @Override
    @Transactional
    public MetadataVO saveMetadata(MetadataVO metadataVO) {
        return toMetadataVO(metadataRepository.save(toMetadataEntity(metadataVO)));
    }

    @Override
    @Transactional
    public Set<MetadataVO> findProjectMetadata(Long projectId) {
        return toMetadataVOSet(metadataRepository.findProjectMetadata(projectId));
    }

    @Override
    @Transactional
    public void removeMetadata(MetadataVO metadataVO) {
        metadataRepository.delete(toMetadataEntity(metadataVO));
    }

    public Boolean isAuthorised() {

        return Boolean.TRUE;
    }
}
