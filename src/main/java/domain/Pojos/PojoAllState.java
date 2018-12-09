package domain.Pojos;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class PojoAllState {
    @JSONField(ordinal = 1)
    private String state;
    @JSONField(ordinal = 2)
    private List<PojoReps> reps;



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<PojoReps> getReps() {
        return reps;
    }

    public void setReps(List<PojoReps> reps) {
        this.reps = reps;
    }


}
