package bw.ub.ehealth.redcapddp.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackedEntityAttribute extends NamedEntity {

    private String displayShortName;
    private String formName;
    private String dimensionItemType;

    public TrackedEntityAttribute() {
    }

    public TrackedEntityAttribute(String id, String name, String shortName, String displayName, String displayShortName, String formName, String dimensionItemType) {
        super(id, name, shortName, displayName);
        this.displayShortName = displayShortName;
        this.formName = formName;
        this.dimensionItemType = dimensionItemType;
    }

    public String getDisplayShortName() {
        return displayShortName;
    }

    public void setDisplayShortName(String displayShortName) {
        this.displayShortName = displayShortName;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
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
        TrackedEntityAttribute that = (TrackedEntityAttribute) o;
        return super.equals(that) &&
                Objects.equals(displayShortName, that.displayShortName) &&
                Objects.equals(formName, that.formName) &&
                Objects.equals(dimensionItemType, that.dimensionItemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), displayShortName, formName, dimensionItemType);
    }
}
