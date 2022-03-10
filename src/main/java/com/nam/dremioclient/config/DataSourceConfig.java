package com.nam.dremioclient.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.nam.dremioclient.config.ApplicationProperties.DremioProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

	private String dbDriverClass = "com.dremio.jdbc.Driver";

	@Bean
	public DataSource dataSource(DremioProperties dremioProp) {

		HikariConfig configuration = new HikariConfig();
		
		configuration.setJdbcUrl(dremioProp.getUrl()); 
		configuration.setUsername(dremioProp.getUsername());
		configuration.setPassword(dremioProp.getPassword());
		configuration.setDriverClassName(dbDriverClass);
		configuration.setMaximumPoolSize(20);
		configuration.setConnectionTestQuery("SELECT * FROM sahub.poc.\"assets\" fetch first 1 rows only");
		configuration.setConnectionTimeout(30000);
		configuration.setMaxLifetime(1800000); 
		configuration.setMinimumIdle(1);

		return new HikariDataSource(configuration);
	}

	@Bean
	public DataSourceTransactionManager transactionManager(
			DataSource datasource) {
		return new DataSourceTransactionManager(datasource);
	}

	@Bean
	public JdbcTemplate saccJdbcTemplate(DataSource saccDataSource) {
		return new JdbcTemplate(saccDataSource);
	}

	@Bean
	public NamedParameterJdbcTemplate saccNamedParameterJdbcTemplate(
			DataSource saccDataSource) {
		return new NamedParameterJdbcTemplate(saccDataSource);
	}
}
