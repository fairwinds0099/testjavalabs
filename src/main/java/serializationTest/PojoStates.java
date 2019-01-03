package serializationTest;

import java.util.List;

public class PojoStates {
    private String state;
    private List<PojoRepresentatives> representatives;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List <PojoRepresentatives> getRepresentatives() {
        return representatives;
    }

    public void setRepresentatives(List <PojoRepresentatives> representatives) {
        this.representatives = representatives;
    }
}
