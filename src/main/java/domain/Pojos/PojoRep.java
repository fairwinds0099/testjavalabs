package domain.Pojos;

import java.util.List;

public class PojoRep {
    private String name;
    private String phone;
    private List<String> committees;

    public PojoRep(String name, String phone, List<String> committees){
        this.name = name;
        this.phone = phone;
        this.committees = committees;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getCommittees() {
        return committees;
    }

    public void setCommittees(List<String> committees) {
        this.committees = committees;
    }




}
