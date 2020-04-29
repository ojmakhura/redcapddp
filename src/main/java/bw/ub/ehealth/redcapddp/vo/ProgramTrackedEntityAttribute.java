package bw.ub.ehealth.redcapddp.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgramTrackedEntityAttribute extends NamedEntity{

    private Value program;
    private Value trackedEntityAttribute;
    private Boolean mandatory;

    public ProgramTrackedEntityAttribute(String id, String name, String shortName, String displayName, Value program, Value trackedEntityAttribute, Boolean mandatory) {
        super(id, name, shortName, displayName);
        this.program = program;
        this.trackedEntityAttribute = trackedEntityAttribute;
        this.mandatory = mandatory;
    }

    public ProgramTrackedEntityAttribute() {
    }

    public Value getProgram() {
        return program;
    }

    public void setProgram(Value program) {
        this.program = program;
    }

    public Value getTrackedEntityAttribute() {
        return trackedEntityAttribute;
    }

    public void setTrackedEntityAttribute(Value trackedEntityAttribute) {
        this.trackedEntityAttribute = trackedEntityAttribute;
    }

    public Boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }
}
