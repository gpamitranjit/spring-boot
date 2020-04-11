package com.amit.app.persistance.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.amit.app.datasource2.repository.OrderRepository;

/**
*
* @author Amit Patil
*
**/
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "orderEntityManagerFactoryRef",
		transactionManagerRef = "orderTransactionManagerRef",
		basePackageClasses = {OrderRepository.class})
public class OrderPersistanceConfig {

	@Bean
	JpaTransactionManager orderTransactionManagerRef() {
		return new JpaTransactionManager(orderEntityManagerFactoryRef().getObject());
	}

	@Bean
	LocalContainerEntityManagerFactoryBean orderEntityManagerFactoryRef() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setDataSource(orderDataSource());
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan("com.amit.app.datasource2.model");

		return factoryBean;
	}
	
	@Bean
	DataSource orderDataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.setName("orders")
				.build();
	}	
}
