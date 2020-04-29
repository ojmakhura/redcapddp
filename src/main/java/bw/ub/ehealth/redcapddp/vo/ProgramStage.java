package bw.ub.ehealth.redcapddp.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgramStage extends NamedEntity {

    private String formType;
    private Value program;
    private Value lastUpdatedBy;
    private List<DataElement> programStageDataElements;
    private List<Value> programStageSections;

    public ProgramStage() {
    }

    public ProgramStage(String id, String name, String shortName, String displayName, String formType, Value program, Value lastUpdatedBy) {
        super(id, name, shortName, displayName);
        this.formType = formType;
        this.program = program;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public Value getProgram() {
        return program;
    }

    public void setProgram(Value program) {
        this.program = program;
    }

    public Value getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Value lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public List<DataElement> getProgramStageDataElements() {
        return programStageDataElements;
    }

    public void setProgramStageDataElements(List<DataElement> programStageDataElements) {
        this.programStageDataElements = programStageDataElements;
    }

    public List<Value> getProgramStageSections() {
        return programStageSections;
    }

    public void setProgramStageSections(List<Value> programStageSections) {
        this.programStageSections = programStageSections;
    }
}
