package com.imdb.config.db;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
public class DBConfig {

	@Bean
	public LocalSessionFactoryBean sessionFactory(@Autowired DataSource dataSource) {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(dataSource);
		sf.setPackagesToScan("com.imdb.model");
		Properties prop = new Properties();
		prop.setProperty("hibernate.id.new_generator_mappings", "false");
		sf.setHibernateProperties(prop);
		return sf;
	}
	
	
	
}
