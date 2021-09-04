package vn.minhtran.study.wsm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileManagementConfiguration {
	
	@Bean
	@ConfigurationProperties(prefix = "file-management")
	FileManagementProperties fileManagementProperties() {
		return new FileManagementProperties();
	}
}
