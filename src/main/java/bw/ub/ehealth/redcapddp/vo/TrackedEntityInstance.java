package bw.ub.ehealth.redcapddp.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackedEntityInstance {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date created;
    private String orgUnit;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date createdAtClient;
    private String trackedEntityInstance;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date lastUpdated;
    private String trackedEntityType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date lastUpdatedAtClient;
    private List<TrackedEntityInstanceAttribute> attributes;

    public TrackedEntityInstance() {
        attributes = new ArrayList<>();
    }

    public TrackedEntityInstance(Date created, String orgUnit, Date createdAtClient, String trackedEntityInstance, Date lastUpdated, String trackedEntityType, Date lastUpdatedAtClient, List<TrackedEntityInstanceAttribute> attributes) {
        this.created = created;
        this.orgUnit = orgUnit;
        this.createdAtClient = createdAtClient;
        this.trackedEntityInstance = trackedEntityInstance;
        this.lastUpdated = lastUpdated;
        this.trackedEntityType = trackedEntityType;
        this.lastUpdatedAtClient = lastUpdatedAtClient;
        this.attributes = attributes;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getOrgUnit() {
        return orgUnit;
    }

    public void setOrgUnit(String orgUnit) {
        this.orgUnit = orgUnit;
    }

    public Date getCreatedAtClient() {
        return createdAtClient;
    }

    public void setCreatedAtClient(Date createdAtClient) {
        this.createdAtClient = createdAtClient;
    }

    public String getTrackedEntityInstance() {
        return trackedEntityInstance;
    }

    public void setTrackedEntityInstance(String trackedEntityInstance) {
        this.trackedEntityInstance = trackedEntityInstance;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getTrackedEntityType() {
        return trackedEntityType;
    }

    public void setTrackedEntityType(String trackedEntityType) {
        this.trackedEntityType = trackedEntityType;
    }

    public Date getLastUpdatedAtClient() {
        return lastUpdatedAtClient;
    }

    public void setLastUpdatedAtClient(Date lastUpdatedAtClient) {
        this.lastUpdatedAtClient = lastUpdatedAtClient;
    }

    public List<TrackedEntityInstanceAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<TrackedEntityInstanceAttribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackedEntityInstance that = (TrackedEntityInstance) o;
        return orgUnit.equals(that.orgUnit) &&
                trackedEntityInstance.equals(that.trackedEntityInstance) &&
                trackedEntityType.equals(that.trackedEntityType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orgUnit, trackedEntityInstance, trackedEntityType);
    }
}
