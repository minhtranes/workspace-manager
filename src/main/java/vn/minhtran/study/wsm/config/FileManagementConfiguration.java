package vn.minhtran.study.wsm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class FileManagementConfiguration {
	
	@Bean
	@ConfigurationProperties(prefix = "file-management")
	FileManagementProperties fileManagementProperties() {
		return new FileManagementProperties();
	}
}
