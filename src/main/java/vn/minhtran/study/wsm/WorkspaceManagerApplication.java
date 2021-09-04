package vn.minhtran.study.wsm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.SocketUtils;

@SpringBootApplication
public class WorkspaceManagerApplication {
	private static final Logger LOGGER =LoggerFactory.getLogger(WorkspaceManagerApplication.class);
	
	public static void main(String[] args) {
		int port = SocketUtils.findAvailableTcpPort(8000, 10000);
		System.setProperty("server.port", String.valueOf(port));
		LOGGER.info("Random Server Port is set to {}.", port);
		SpringApplication.run(WorkspaceManagerApplication.class, args);
	}

}
