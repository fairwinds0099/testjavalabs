/*
package utils;


import com.jcraft.jsch.*;

import java.io.InputStream;

public class ServerHelpers {

    public static void executeCommand(String command, ServerConfig serverConfig) {

        JSch jsch = new JSch();
        Session session = null;
        ChannelExec channelExec;

        try {
            session = jsch.getSession(serverConfig.getUserName(), serverConfig.getHostName(), serverConfig.getPort());
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(serverConfig.getPassword());
            session.connect();

            channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand(command);
            channelExec.connect();
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

}
*/
