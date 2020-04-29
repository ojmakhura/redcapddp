package bw.ub.ehealth.redcapddp.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackedEntityInstanceList {

    private List<TrackedEntityInstance> instances;

    public TrackedEntityInstanceList() {
        instances = new ArrayList<>();
    }

    public TrackedEntityInstanceList(List<TrackedEntityInstance> instances) {
        this.instances = instances;
    }

    public List<TrackedEntityInstance> getInstances() {
        return instances;
    }

    public void setInstances(List<TrackedEntityInstance> instances) {
        this.instances = instances;
    }
}
