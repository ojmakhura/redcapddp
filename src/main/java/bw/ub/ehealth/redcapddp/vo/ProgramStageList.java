package bw.ub.ehealth.redcapddp.vo;

import java.util.ArrayList;
import java.util.List;

public class ProgramStageList {

    List<ProgramStage> programStages;

    public ProgramStageList() {
        programStages = new ArrayList<>();
    }

    public ProgramStageList(List<ProgramStage> programStages) {
        this.programStages = programStages;
    }

    public List<ProgramStage> getProgramStages() {
        return programStages;
    }

    public void setProgramStages(List<ProgramStage> programStages) {
        this.programStages = programStages;
    }
}
