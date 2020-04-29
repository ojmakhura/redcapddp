package bw.ub.ehealth.redcapddp.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgramTrackedEntityAttributeList {

    List<ProgramTrackedEntityAttribute> programTrackedEntityAttributes;

    public ProgramTrackedEntityAttributeList(List<ProgramTrackedEntityAttribute> programTrackedEntityAttributes) {
        this.programTrackedEntityAttributes = programTrackedEntityAttributes;
    }

    public ProgramTrackedEntityAttributeList() {
        programTrackedEntityAttributes = new ArrayList<>();
    }

    public List<ProgramTrackedEntityAttribute> getProgramTrackedEntityAttributes() {
        return programTrackedEntityAttributes;
    }

    public void setProgramTrackedEntityAttributes(List<ProgramTrackedEntityAttribute> programTrackedEntityAttributes) {
        this.programTrackedEntityAttributes = programTrackedEntityAttributes;
    }
}
