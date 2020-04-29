package bw.ub.ehealth.redcapddp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "redcap_config", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "field_name",
                "value"
        })
})
@IdClass(RedcapConfigId.class)
public class RedcapConfig implements Serializable {

    @Id
    @Column(name = "field_name")
    private String fieldName;

    @Id
    @Column(name = "value")
    private String value;

    public RedcapConfig(String fieldName, String value) {
        this.fieldName = fieldName;
        this.value = value;
    }

    public RedcapConfig() {
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
