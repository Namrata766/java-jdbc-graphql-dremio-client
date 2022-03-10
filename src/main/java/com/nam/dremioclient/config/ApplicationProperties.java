package com.nam.dremioclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
public class ApplicationProperties {
	
	@Data
	@Configuration
	@ConfigurationProperties("dremio")
	public class DremioProperties {
		
		private String url;
		private String username;
		private String password;
	}
}
