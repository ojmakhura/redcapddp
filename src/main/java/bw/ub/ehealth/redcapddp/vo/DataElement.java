package bw.ub.ehealth.redcapddp.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataElement extends NamedEntity{

    private String formName;
    private String displayFormName;
    private String dimensionItemType;

    public DataElement(String id, String name, String displayName, String shortName, String formName, String displayFormName, String dimensionItemType) {

        super(id, name, displayName, shortName);
        this.formName = formName;
        this.displayFormName = displayFormName;
        this.dimensionItemType = dimensionItemType;
    }

    public DataElement() {
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getDisplayFormName() {
        return displayFormName;
    }

    public void setDisplayFormName(String displayFormName) {
        this.displayFormName = displayFormName;
    }

    public String getDimensionItemType() {
        return dimensionItemType;
    }

    public void setDimensionItemType(String dimensionItemType) {
        this.dimensionItemType = dimensionItemType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DataElement that = (DataElement) o;
        return super.equals(that) &&
                formName.equals(that.formName) &&
                displayFormName.equals(that.displayFormName) &&
                dimensionItemType.equals(that.dimensionItemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), formName, displayFormName, dimensionItemType);
    }
}
