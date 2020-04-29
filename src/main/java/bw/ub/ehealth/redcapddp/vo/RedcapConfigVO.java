package bw.ub.ehealth.redcapddp.vo;

import java.io.Serializable;
import java.util.Objects;

public class RedcapConfigVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2302303316907784886L;
	private String fieldName;
    private String value;

    public RedcapConfigVO() {
    }

    public RedcapConfigVO(String fieldName, String value) {
        this.fieldName = fieldName;
        this.value = value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RedcapConfigVO that = (RedcapConfigVO) o;
        return fieldName.equals(that.fieldName) &&
                value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, value);
    }
}
