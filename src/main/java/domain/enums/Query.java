package domain.enums;

//TODO to be updated
public enum Query {
    REPBYID("SELECT CITY FROM ADDRESS WHERE ID = ?"),
    SEARCHBYSTATE("SELECT STATE FROM ADDRESS WHERE ID = ?");

    private String query;

    Query(String query) {this.query = query;}

    public String getQuery() {return query; }

}
