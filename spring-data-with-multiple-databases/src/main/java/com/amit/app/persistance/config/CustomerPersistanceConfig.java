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

import com.amit.app.datasource1.repository.CustomerRepository;

/**
*
* @author Amit Patil
*
**/
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "customerEntityManagerFactoryRef",
		transactionManagerRef = "customerTransactionManagerRef",
		basePackageClasses = {CustomerRepository.class})
public class CustomerPersistanceConfig {

	@Bean
	JpaTransactionManager customerTransactionManagerRef() {
		return new JpaTransactionManager(customerEntityManagerFactoryRef().getObject());
	}

	@Bean
	LocalContainerEntityManagerFactoryBean customerEntityManagerFactoryRef() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setDataSource(customerDataSource());
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan("com.amit.app.datasource1.model");

		return factoryBean;
	}
	
	@Bean
	DataSource customerDataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.setName("customers")
				.build();
	}
}
