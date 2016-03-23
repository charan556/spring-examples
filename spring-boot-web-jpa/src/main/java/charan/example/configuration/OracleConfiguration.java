package charan.example.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Setter;
import oracle.jdbc.pool.OracleDataSource;

@Configuration
@ConfigurationProperties("oracle")
public class OracleConfiguration {
	@NotNull
	@Setter
	private String username;

	@NotNull
	@Setter
	private String password;

	@NotNull
	@Setter
	private String url;

	@Bean
	DataSource dataSource() throws SQLException {

		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser(username);
		dataSource.setPassword(password);
		dataSource.setURL(url);
		//dataSource.setImplicitCachingEnabled(true);
		//dataSource.setFastConnectionFailoverEnabled(true);
		return dataSource;
	}
}
