package bw.ub.ehealth.redcapddp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "redcap_ddp_specimen", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "batch_number"
        })
})
public class Specimen implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2504372880121617178L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "batch_number",  nullable = false)
    private String batchNumber;

    @Column(name = "dispatch_date_time", nullable = false)
    private Instant dispatchedDateTime;

    @Column(name = "sample_status", nullable = false)
    private String sampleStatus;

    @Column(name = "dispatcher", nullable = false)
    private String dispatcher;

    @Column(name = "dispatch_location", nullable = false)
    private String dispatchLocation;

    @Column(name = "collection_date_time", nullable = false)
    private Instant collectionDateTime;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "location_details")
    private String locationDetails;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    public Specimen() {
    }

    public Specimen(Patient patient, String batchNumber, Instant dispatchedDateTime, String sampleStatus, String dispatcher, String dispatchLocation, Instant collectionDateTime, String latitude, String longitude, String locationDetails) {
        this.batchNumber = batchNumber;
        this.dispatchedDateTime = dispatchedDateTime;
        this.sampleStatus = sampleStatus;
        this.dispatcher = dispatcher;
        this.dispatchLocation = dispatchLocation;
        this.collectionDateTime = collectionDateTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationDetails = locationDetails;
        this.patient = patient;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public static Specimen instance() {
        Specimen specimen = new Specimen();

        specimen.setPatient(null);

        return specimen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specimen specimen = (Specimen) o;
        return batchNumber.equals(specimen.batchNumber) &&
                dispatchedDateTime.equals(specimen.dispatchedDateTime) &&
                dispatchLocation.equals(specimen.dispatchLocation) &&
                patient.equals(specimen.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batchNumber, dispatchedDateTime, dispatchLocation, patient);
    }
}
