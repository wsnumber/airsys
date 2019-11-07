package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 数据库配置
 * 配置类要告诉你的配置信息的位置
 * 利用IOC功能注入配置信息  @Value
 * @author ll
 *
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DBconfig {
	
	//  1  配置信息
	@Value("${jdbc.driverClass}")
	private String driverclass;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	//  2 DataSource Bean
	
	@Bean(name="dataSource")
	public DataSource createDataSource() {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(driverclass);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	@Bean(name="jdbcTemplate")
	public JdbcTemplate createJdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
