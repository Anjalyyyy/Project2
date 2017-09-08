package com.niit.collaborate.CollaborationBackend;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.niit.collaborate.CollaborationBackend")
@EnableTransactionManagement
public class DBConfig {
	public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        dataSource.setUsername("hr");
		dataSource.setPassword("oracle");
		return dataSource;
	}
	private Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	    properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
 
	 @Bean
	    public SessionFactory getSessionFactory()
	    {
		 LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder();
		 LocalSessionFactoryBuilder.addProperties(getHibernateProperties());
	    }
	    
	
}
