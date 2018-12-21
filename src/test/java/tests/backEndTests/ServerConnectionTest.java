package tests.backEndTests;

import org.junit.Test;
import utils.ServerConfig;
import utils.ServerHelpers;

public class ServerConnectionTest {

//TODO get a remote linux
    ServerConfig ec2Aws = ServerConfig.getConfiguration()
            .withHostName("mydbinstance.cn1e1hoy5jio.us-east-1.rds.amazonaws.com")
            .withPort(1521)
            .withDbName("ORCL")
            .withUserName("fairwinds")
            .withPassword("Sb123456")
            .build();

    @Test
    public void sendMakeDirCommandToServer() {
        ServerHelpers.executeCommand("mkdir resources", ec2Aws);
    }
}
