package tests.dbTests;

public class DatabaseConnection {

    public static class Builder {
        private String dbUri;
        private String dbUserName;
        private String dbPassword;
        private String dbPort;
        private String dbName;

        public Builder() {
        }

        public DatabaseConnection build() {
            return new DatabaseConnection(this);
        }

        public Builder dbUri(String dbUri) {
            this.dbUri = dbUri;
            return this;
        }

        public Builder dbUserName(String dbUserName) {
            this.dbUserName = dbUserName;
            return this;
        }

        public Builder dbPassword(String dbPassword) {
            this.dbPassword = dbPassword;
            return this;
        }

        public Builder dbPort(String dbPort){
            this.dbPort = dbPort;
            return this;
        }

        public Builder dbName(String dbName){
            this.dbName = dbName;
            return this;
        }
    }

    private final String dbUri;
    private final String dbUserName;
    private final String dbPassword;
    private final String dbPort;
    private final String dbName;

    private DatabaseConnection(Builder builder) {
        this.dbUri = builder.dbUri;
        this.dbUserName = builder.dbUserName;
        this.dbPassword = builder.dbPassword;
        this.dbPort = builder.dbPort;
        this.dbName = builder.dbName;
    }

    public String getDbUri() {
        return dbUri;
    }

    public String getDbUserName() {
        return dbUserName;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbPort() {
        if (dbPort != "1521") {
            return dbPort;
        }else{
            return "1521";
            }

        }

    public String getDbName(){
        return dbName;
    }
}
