package org.ignou.lltp;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.ignou.lltp.dao.UserDao;
import org.ignou.lltp.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
@Configuration
@EnableJpaRepositories

public class BeanConfiguration {

	
	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new org.apache.commons.dbcp.BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		//ds.setUrl(env.getProperty("dbUrl"));
		ds.setUrl("jdbc:mysql://localhost:3306/lltp");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(dataSource);
		lef.setJpaVendorAdapter(jpaVendorAdapter);
		lef.setPackagesToScan("org.ignou.lltp");
		return lef;
	}
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		return hibernateJpaVendorAdapter;
	}
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}
	
	 @Bean
	 public UserDao getContactDAO() {
	        return new UserDaoImpl(dataSource());
	    }
}