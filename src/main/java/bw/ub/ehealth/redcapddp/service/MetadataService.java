package bw.ub.ehealth.redcapddp.service;

import bw.ub.ehealth.redcapddp.vo.MetadataVO;

import java.util.Set;

public interface MetadataService {

    MetadataVO saveMetadata(MetadataVO metadataVO);

    Set<MetadataVO> findProjectMetadata(Long projectId);

    void removeMetadata(MetadataVO metadataVO);
}
