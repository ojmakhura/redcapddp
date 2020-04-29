package bw.ub.ehealth.redcapddp.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataValue {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date lastUpdated;
    private String storedBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date created;
    private String dataElement;
    private String value;
    private Boolean providedElsewhere;

    public DataValue(Date lastUpdated, String storedBy, Date created, String dataElement, String value, Boolean providedElsewhere) {
        this.lastUpdated = lastUpdated;
        this.storedBy = storedBy;
        this.created = created;
        this.dataElement = dataElement;
        this.value = value;
        this.providedElsewhere = providedElsewhere;
    }

    public DataValue() {
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getStoredBy() {
        return storedBy;
    }

    public void setStoredBy(String storedBy) {
        this.storedBy = storedBy;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDataElement() {
        return dataElement;
    }

    public void setDataElement(String dataElement) {
        this.dataElement = dataElement;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getProvidedElsewhere() {
        return providedElsewhere;
    }

    public void setProvidedElsewhere(Boolean providedElsewhere) {
        this.providedElsewhere = providedElsewhere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataValue dataValue = (DataValue) o;
        return lastUpdated.equals(dataValue.lastUpdated) &&
                storedBy.equals(dataValue.storedBy) &&
                created.equals(dataValue.created) &&
                dataElement.equals(dataValue.dataElement) &&
                value.equals(dataValue.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastUpdated, storedBy, created, dataElement, value);
    }
}
