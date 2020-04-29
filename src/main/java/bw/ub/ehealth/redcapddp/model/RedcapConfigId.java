package bw.ub.ehealth.redcapddp.model;

import java.io.Serializable;
import java.util.Objects;

public class RedcapConfigId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2673931616708041992L;
	private String fieldName;
    private String value;

    public RedcapConfigId() {
    }

    public RedcapConfigId(String fieldName, String value) {
        this.fieldName = fieldName;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RedcapConfigId that = (RedcapConfigId) o;
        return fieldName.equals(that.fieldName) &&
                value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, value);
    }
}
