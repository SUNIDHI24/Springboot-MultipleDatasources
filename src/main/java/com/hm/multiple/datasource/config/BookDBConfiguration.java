package com.hm.multiple.datasource.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableJpaRepositories(entityManagerFactoryRef = "bookEntityManagerFactory",
                       transactionManagerRef = "bookTransactionManager", 
                       basePackages = {
		               "com.hm.multiple.datasource.book.repository" })
public class BookDBConfiguration {
	
	@Bean(name = "bookDataSource")
	@ConfigurationProperties(prefix = "spring.book.datasource")
	public DataSource bookDataSource() {
		return DataSourceBuilder.create().build();
	}

	 @Bean(name = "emfbBook")
	 public EntityManagerFactoryBuilder bookentityManagerFactoryBuilder() {
	    return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
	 }
	


	@Bean(name = "bookEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean bookEntityManagerFactory(@Qualifier("emfbBook") EntityManagerFactoryBuilder builder,
			@Qualifier("bookDataSource") DataSource dataSource) {
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		return builder.dataSource(dataSource).properties(properties)
				.packages("com.hm.multiple.datasource.model").build();
	}

	@Bean(name = "bookTransactionManager")
	public PlatformTransactionManager bookTransactionManager(
			@Qualifier("bookEntityManagerFactory") EntityManagerFactory bookEntityManagerFactory) {
		return new JpaTransactionManager(bookEntityManagerFactory);
	}

}
