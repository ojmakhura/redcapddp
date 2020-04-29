package bw.ub.ehealth.redcapddp.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Program extends NamedEntity {

    private String displayShortName;
    private String programType;
    private Value categoryCombo;
    private List<Value> programIndicators;
    private List<Value> programRuleVariables;
    private List<Value> programStages;
    private List<TrackedEntityAttribute> programTrackedEntityAttributes;

    public Program() {
    }

    public Program(String displayShortName, String programType, Value categoryCombo) {
        this.displayShortName = displayShortName;
        this.programType = programType;
        this.categoryCombo = categoryCombo;
    }

    public String getDisplayShortName() {
        return displayShortName;
    }

    public void setDisplayShortName(String displayShortName) {
        this.displayShortName = displayShortName;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public Value getCategoryCombo() {
        return categoryCombo;
    }

    public void setCategoryCombo(Value categoryCombo) {
        this.categoryCombo = categoryCombo;
    }

    public List<Value> getProgramIndicators() {
        return programIndicators;
    }

    public void setProgramIndicators(List<Value> programIndicators) {
        this.programIndicators = programIndicators;
    }

    public List<Value> getProgramRuleVariables() {
        return programRuleVariables;
    }

    public void setProgramRuleVariables(List<Value> programRuleVariables) {
        this.programRuleVariables = programRuleVariables;
    }

    public List<Value> getProgramStages() {
        return programStages;
    }

    public void setProgramStages(List<Value> programStages) {
        this.programStages = programStages;
    }

    public List<TrackedEntityAttribute> getProgramTrackedEntityAttributes() {
        return programTrackedEntityAttributes;
    }

    public void setProgramTrackedEntityAttributes(List<TrackedEntityAttribute> programTrackedEntityAttributes) {
        this.programTrackedEntityAttributes = programTrackedEntityAttributes;
    }
}
