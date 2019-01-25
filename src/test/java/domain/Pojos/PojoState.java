package domain.Pojos;

import java.util.List;

public class PojoState {

    private String state;
    private List<PojoRep> reps;
    private int id;

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
