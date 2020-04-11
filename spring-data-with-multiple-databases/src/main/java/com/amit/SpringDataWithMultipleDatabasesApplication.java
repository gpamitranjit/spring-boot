package com.amit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
*
* @author Amit Patil
*
**/
@SpringBootApplication
@ComponentScan(basePackages = "com.amit")
public class SpringDataWithMultipleDatabasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataWithMultipleDatabasesApplication.class, args);
	}

}
