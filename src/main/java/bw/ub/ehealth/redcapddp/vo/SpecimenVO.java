package bw.ub.ehealth.redcapddp.vo;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class SpecimenVO implements Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2588847151983910325L;
	private Long id;
    private PatientVO patientVO;
    private String batchNumber;
    private Instant dispatchedDateTime;
    private String sampleStatus;
    private String dispatcher;
    private String dispatchLocation;
    private Instant collectionDateTime;
    private String latitude;
    private String longitude;
    private String locationDetails;

    public SpecimenVO() {
    }

    public SpecimenVO(Long id, PatientVO patientVO, String batchNumber, Instant dispatchedDateTime, String sampleStatus, String dispatcher, String dispatchLocation, Instant collectionDateTime, String latitude, String longitude, String locationDetails) {
        this.id = id;
        this.patientVO = patientVO;
        this.batchNumber = batchNumber;
        this.dispatchedDateTime = dispatchedDateTime;
        this.sampleStatus = sampleStatus;
        this.dispatcher = dispatcher;
        this.dispatchLocation = dispatchLocation;
        this.collectionDateTime = collectionDateTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationDetails = locationDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Instant getDispatchedDateTime() {
        return dispatchedDateTime;
    }

    public void setDispatchedDateTime(Instant dispatchedDateTime) {
        this.dispatchedDateTime = dispatchedDateTime;
    }

    public String getSampleStatus() {
        return sampleStatus;
    }

    public void setSampleStatus(String sampleStatus) {
        this.sampleStatus = sampleStatus;
    }

    public String getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(String dispatcher) {
        this.dispatcher = dispatcher;
    }

    public String getDispatchLocation() {
        return dispatchLocation;
    }

    public void setDispatchLocation(String dispatchLocation) {
        this.dispatchLocation = dispatchLocation;
    }

    public Instant getCollectionDateTime() {
        return collectionDateTime;
    }

    public void setCollectionDateTime(Instant collectionDateTime) {
        this.collectionDateTime = collectionDateTime;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(String locationDetails) {
        this.locationDetails = locationDetails;
    }

    public PatientVO getPatientVO() {
        return patientVO;
    }

    public void setPatientVO(PatientVO patientVO) {
        this.patientVO = patientVO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecimenVO that = (SpecimenVO) o;
        return batchNumber.equals(that.batchNumber) &&
                dispatchedDateTime.equals(that.dispatchedDateTime) &&
                sampleStatus.equals(that.sampleStatus) &&
                dispatcher.equals(that.dispatcher) &&
                dispatchLocation.equals(that.dispatchLocation) &&
                collectionDateTime.equals(that.collectionDateTime) &&
                patientVO.getIdNumber().equals(that.patientVO.getIdNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientVO.getIdNumber(), batchNumber, dispatchedDateTime, sampleStatus, dispatcher, dispatchLocation, collectionDateTime);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        // Batch number
        builder.append("{\n");
        builder.append("    \"field\" : \"");
        builder.append("batchNumber" + "\",\n");

        builder.append("    \"value\" : \"");
        builder.append(batchNumber + "\",\n");

        builder.append("    \"timestamp\" : \"");
        builder.append(collectionDateTime + "\",\n");

        builder.append("},");

        // Dispatch data and time
        builder.append("{\n");
        builder.append("    \"field\" : \"");
        builder.append("dispatchedDateTime" + "\",\n");

        builder.append("    \"value\" : \"");
        builder.append(dispatchedDateTime + "\",\n");

        builder.append("    \"timestamp\" : \"");
        builder.append(collectionDateTime + "\",\n");
        builder.append("},");

        // sampleStatus
        builder.append("{\n");
        builder.append("    \"field\" : \"");
        builder.append("sampleStatus" + "\",\n");

        builder.append("    \"value\" : \"");
        builder.append(sampleStatus + "\",\n");

        builder.append("    \"timestamp\" : \"");
        builder.append(collectionDateTime + "\",\n");
        builder.append("},");

        // dispatcher
        builder.append("{\n");
        builder.append("    \"field\" : \"");
        builder.append("dispatcher" + "\",\n");

        builder.append("    \"value\" : \"");
        builder.append(dispatcher + "\",\n");

        builder.append("    \"timestamp\" : \"");
        builder.append(collectionDateTime + "\",\n");
        builder.append("},");

        // dispatcher
        builder.append("{\n");
        builder.append("    \"field\" : \"");
        builder.append("dispatchLocation" + "\",\n");

        builder.append("    \"value\" : \"");
        builder.append(dispatchLocation + "\",\n");

        builder.append("    \"timestamp\" : \"");
        builder.append(collectionDateTime + "\"\n");
        builder.append("},");

        // longitude
        builder.append("{\n");
        builder.append("    \"field\" : \"");
        builder.append("longitude" + "\",\n");

        builder.append("    \"value\" : \"");
        builder.append(longitude + "\",\n");

        builder.append("    \"timestamp\" : \"");
        builder.append(collectionDateTime + "\"\n");
        builder.append("},");

        // latitude
        builder.append("{\n");
        builder.append("    \"field\" : \"");
        builder.append("latitude" + "\",\n");

        builder.append("    \"value\" : \"");
        builder.append(latitude + "\",\n");

        builder.append("    \"timestamp\" : \"");
        builder.append(collectionDateTime + "\"\n");
        builder.append("},");

        // locationDetails
        builder.append("{\n");
        builder.append("    \"field\" : \"");
        builder.append("locationDetails" + "\",\n");

        builder.append("    \"value\" : \"");
        builder.append(locationDetails + "\",\n");

        builder.append("    \"timestamp\" : \"");
        builder.append(collectionDateTime + "\"\n");
        builder.append("}");

        return builder.toString();
    }
}
