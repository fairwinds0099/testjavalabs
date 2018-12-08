package domain.Pojos;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class PojoReps {
    private String name;
    private String party;
    @JSONField(ordinal = 3, name="DATE OF BIRTH", format="dd/MM/yyyy")
    private Date dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public Date getDateOfBirth(){return dateOfBirth;}

    public void setDateOfBirth(Date DateOfBirth){ this.dateOfBirth = dateOfBirth;}

}
