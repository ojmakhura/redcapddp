package bw.ub.ehealth.redcapddp.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

    private String event;
    private String programStage;
    private String orgUnit;
    private String orgUnitName;
    private String trackedEntityInstance;
    private String enrollment;
    private String enrollmentStatus;
    private String status;
    private String program;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date dueDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date eventDate;
    private String attributeOptionCombo;
    private String completeBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date createdAtClient;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date lastUpdatedAtClient;
    private List<DataValue> dataValues;

    public Event() {
    }

    public Event(String event, String programStage, String orgUnit, String orgUnitName, String trackedEntityInstance, String enrollment, String enrollmentStatus, String status, String program, Date dueDate, Date eventDate, String attributeOptionCombo, String completeBy, Date createdAtClient, Date lastUpdatedAtClient, List<DataValue> dataValues) {
        this.event = event;
        this.programStage = programStage;
        this.orgUnit = orgUnit;
        this.orgUnitName = orgUnitName;
        this.trackedEntityInstance = trackedEntityInstance;
        this.enrollment = enrollment;
        this.enrollmentStatus = enrollmentStatus;
        this.status = status;
        this.program = program;
        this.dueDate = dueDate;
        this.eventDate = eventDate;
        this.attributeOptionCombo = attributeOptionCombo;
        this.completeBy = completeBy;
        this.createdAtClient = createdAtClient;
        this.lastUpdatedAtClient = lastUpdatedAtClient;
        this.dataValues = dataValues;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getProgramStage() {
        return programStage;
    }

    public void setProgramStage(String programStage) {
        this.programStage = programStage;
    }

    public String getOrgUnit() {
        return orgUnit;
    }

    public void setOrgUnit(String orgUnit) {
        this.orgUnit = orgUnit;
    }

    public String getOrgUnitName() {
        return orgUnitName;
    }

    public void setOrgUnitName(String orgUnitName) {
        this.orgUnitName = orgUnitName;
    }

    public String getTrackedEntityInstance() {
        return trackedEntityInstance;
    }

    public void setTrackedEntityInstance(String trackedEntityInstance) {
        this.trackedEntityInstance = trackedEntityInstance;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getAttributeOptionCombo() {
        return attributeOptionCombo;
    }

    public void setAttributeOptionCombo(String attributeOptionCombo) {
        this.attributeOptionCombo = attributeOptionCombo;
    }

    public String getCompleteBy() {
        return completeBy;
    }

    public void setCompleteBy(String completeBy) {
        this.completeBy = completeBy;
    }

    public Date getCreatedAtClient() {
        return createdAtClient;
    }

    public void setCreatedAtClient(Date createdAtClient) {
        this.createdAtClient = createdAtClient;
    }

    public Date getLastUpdatedAtClient() {
        return lastUpdatedAtClient;
    }

    public void setLastUpdatedAtClient(Date lastUpdatedAtClient) {
        this.lastUpdatedAtClient = lastUpdatedAtClient;
    }

    public List<DataValue> getDataValues() {
        return dataValues;
    }

    public void setDataValues(List<DataValue> dataValues) {
        this.dataValues = dataValues;
    }
}
