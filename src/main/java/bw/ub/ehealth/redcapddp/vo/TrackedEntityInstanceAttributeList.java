package bw.ub.ehealth.redcapddp.vo;

import java.util.ArrayList;
import java.util.List;

public class TrackedEntityInstanceAttributeList {

    private List<TrackedEntityInstanceAttribute> attributes;

    public TrackedEntityInstanceAttributeList() {
        attributes = new ArrayList<>();
    }

    public TrackedEntityInstanceAttributeList(List<TrackedEntityInstanceAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<TrackedEntityInstanceAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<TrackedEntityInstanceAttribute> attributes) {
        this.attributes = attributes;
    }
}
