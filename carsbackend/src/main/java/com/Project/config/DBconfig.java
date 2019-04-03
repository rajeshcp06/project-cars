package com.Project.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.Project.model.Category;
import com.Project.model.Product;
import com.Project.model.Supplier;
import com.Project.model.UserDetail;
@Configuration
@EnableTransactionManagement
@Component("com.Project")
public class DBconfig {
	@Bean(name="datasource")	
	 public DataSource getH2DataSource()
	 {
		 DriverManagerDataSource datasource = new DriverManagerDataSource();
		 datasource.setDriverClassName("org.h2.Driver");
		 datasource.setUrl("jdbc:h2:tcp://localhost/~/Project");
		 datasource.setUsername("sa");
		 datasource.setPassword("sa");
		 System.out.println("Datasource created");
		 return datasource;
	 }
	@Bean(name="SessionFactory")
	 public SessionFactory getSessionFactory()
	 {
		Properties hibernateprop= new Properties();
		hibernateprop.put("hibernate.hbm2ddl.auto","update");
		hibernateprop.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder buildfactory = new LocalSessionFactoryBuilder(getH2DataSource());
		buildfactory.addProperties(hibernateprop);
		buildfactory.addAnnotatedClass(Category.class);
		buildfactory.addAnnotatedClass(Supplier.class);
		buildfactory.addAnnotatedClass(Product.class);
		buildfactory.addAnnotatedClass(UserDetail.class);
		SessionFactory sessionFactory=buildfactory.buildSessionFactory();
		System.out.println("=====Sessionfactory created=====");
		return sessionFactory;
				
	 }
	@Bean(name="hibernateTransactionManager")
 public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionfactory)
 {
	 System.out.println("Transaction Manager Object Created");
	 return new HibernateTransactionManager(sessionfactory);
 }
}
