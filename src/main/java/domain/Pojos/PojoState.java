package domain.Pojos;

import java.util.List;

public class PojoState {
    private String state;
    private List<PojoRep> reps;

    public PojoState(String state, List<PojoRep> reps){
        this.state = state;
        this.reps = reps;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<PojoRep> getReps() {
        return reps;
    }

    public void setReps(List<PojoRep> reps) {
        this.reps = reps;
    }




}
