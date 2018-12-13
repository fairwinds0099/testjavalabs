package tests.dbTests;

public class DatabaseConnection {

    public static class Builder {
        private String dbUri;
        private String dbUserName;
        private String dbPassword;

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
    }

    private final String dbUri;
    private final String dbUserName;
    private final String dbPassword;

    private DatabaseConnection(Builder builder) {
        this.dbUri = builder.dbUri;
        this.dbUserName = builder.dbUserName;
        this.dbPassword = builder.dbPassword;
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
}
