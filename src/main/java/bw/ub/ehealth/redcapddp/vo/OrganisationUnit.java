package bw.ub.ehealth.redcapddp.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganisationUnit extends NamedEntity {

    private String dimensionItemType;
    private String displayShortName;
    private List<Value> children;
    private List<Value> organisationUnitGroups;
    private List<Value> dataSets;
    private List<Value> programs;

    public OrganisationUnit() {
    }

    public String getDimensionItemType() {
        return dimensionItemType;
    }

    public void setDimensionItemType(String dimensionItemType) {
        this.dimensionItemType = dimensionItemType;
    }

    public String getDisplayShortName() {
        return displayShortName;
    }

    public void setDisplayShortName(String displayShortName) {
        this.displayShortName = displayShortName;
    }

    public List<Value> getChildren() {
        return children;
    }

    public void setChildren(List<Value> children) {
        this.children = children;
    }

    public List<Value> getOrganisationUnitGroups() {
        return organisationUnitGroups;
    }

    public void setOrganisationUnitGroups(List<Value> organisationUnitGroups) {
        this.organisationUnitGroups = organisationUnitGroups;
    }

    public List<Value> getDataSets() {
        return dataSets;
    }

    public void setDataSets(List<Value> dataSets) {
        this.dataSets = dataSets;
    }

    public List<Value> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Value> programs) {
        this.programs = programs;
    }
}
