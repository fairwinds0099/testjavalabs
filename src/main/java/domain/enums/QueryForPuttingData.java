package domain.enums;

//TODO to be updated
public enum QueryForPuttingData {
    ADDRESSQUERY ("SELECT * FROM ADDRESS  = ?");

    private String query;

    QueryForPuttingData(String query) {this.query = query;}

    public String getQuery() {return query; }

}
