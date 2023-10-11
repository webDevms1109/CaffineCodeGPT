package com.springboot.cruddemo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@PropertySource("classpath:application.properties")
public class PrimaryDataSourceConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	@Primary
	public DataSource dataSource() {
	    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	    dataSource.setDriverClassName(env.getProperty("primary.jpa.database-driver"));
	    dataSource.setUrl(env.getProperty("primary.datasource.url"));
	    dataSource.setUsername(env.getProperty("primary.datasource.username"));
	    dataSource.setPassword(env.getProperty("primary.datasource.password"));
	    return dataSource;
	}
	

//	   @Bean("sqlliteEntityManager")
	   @Bean
	   @Primary
	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em 
	        = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource());
	      em.setPackagesToScan(new String[] {"com.springboot.cruddemo"});
	 
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(additionalProperties());
	 
	      return em;
	   }
	   
	   @Bean
	   @Primary
	   public PlatformTransactionManager transactionManager() {
	       JpaTransactionManager transactionManager = new JpaTransactionManager();
	       transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
	    
	       return transactionManager;
	   }
	   
	   Properties additionalProperties() {
		    Properties properties = new Properties();
		    properties.setProperty("hibernate.hbm2ddl.auto", "update");
		    properties.setProperty("hibernate.dialect", env.getProperty("primary.jpa.database-platform"));
		       
		    return properties;
		}

}
