package utils.DbUtils;

public class ServerConfig {

    private String hostName;
    private String userName;
    private String password;
    private int port;
    private String dbName;

    public static class ServerConfigurator {

        private String hostName;
        private String userName;
        private String password;
        private int port;
        private String dbName;

        private ServerConfigurator() {
        }

        public ServerConfigurator withHostName() {
            this.hostName = hostName;
            return this;
        }

        public ServerConfigurator withUserName() {
            this.userName = userName;
            return this;
        }

        public ServerConfigurator withPassword() {
            this.password = password;
            return this;
        }

        public ServerConfigurator withPort() {
            this.port = port;
            return this;
        }

        public ServerConfigurator withDbName() {
            this.dbName = dbName;
            return this;
        }

        public ServerConfig finishConfiguration() {
            return new ServerConfig(this);
        }
    }

    private ServerConfig(ServerConfigurator builder) {
        this.hostName = builder.hostName;
        this.userName = builder.userName;
        this.password = builder.password;
        this.port = builder.port;
        this.dbName = builder.dbName;
    }

    public static ServerConfigurator getConfiguraton() {
        return new ServerConfigurator();
    }

    public String getHostName() {
        return hostName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }

    public String getDbName() {
        return dbName;
    }
}
