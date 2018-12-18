package utils;

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

        public ServerConfigurator withHostName(String hostName) {
            this.hostName = hostName;
            return this;
        }

        public ServerConfigurator withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public ServerConfigurator withPassword(String password) {
            this.password = password;
            return this;
        }

        public ServerConfigurator withPort(int port) {
            this.port = port;
            return this;
        }

        public ServerConfigurator withDbName(String dbName) {
            this.dbName = dbName;
            return this;
        }

        public ServerConfig build() {
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

    public static ServerConfigurator getConfiguration() {
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
