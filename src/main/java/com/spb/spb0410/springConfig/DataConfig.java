package com.spb.spb0410.springConfig;

// spring configuration 不確定 spring boot 是不是一樣
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer; //SPB 他已經廢棄了
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataConfig {

	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
		configurer.setFileEncoding("UTF-8");
		configurer.setLocations(
				new FileSystemResource(System.getProperty("catalina.home") + "/config/campaign/system.properties"));
		return configurer;
	}

	@Bean("primaryDataSource")
	@Primary
	public static JndiObjectFactoryBean jndiObjectFactoryBean(@Value("${dataSource}") String jndiName) {
		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName(jndiName);
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setProxyInterface(DataSource.class);
		return jndiObjectFactoryBean;
	}

	@Bean("secondaryDataSource")
	public static JndiObjectFactoryBean secondaryjndiObjectFactoryBean(
			@Value("${dataSourceByPaymentUp}") String jndiName) {
		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName(jndiName);
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setProxyInterface(DataSource.class);
		return jndiObjectFactoryBean;
	}

	@Bean
	@Primary
	public static PlatformTransactionManager txManager(@Qualifier("primaryDataSource")DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public PlatformTransactionManager secondaryTxManager(@Qualifier("secondaryDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	@Primary
	public JdbcTemplate jdbcTemplate(@Qualifier("primaryDataSource")DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}