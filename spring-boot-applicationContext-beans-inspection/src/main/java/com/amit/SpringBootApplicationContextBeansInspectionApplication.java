package com.amit;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootApplicationContextBeansInspectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationContextBeansInspectionApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		System.out.println("Let's inspect the beans provided by spring-boot applicationContext");
		return args -> {
			
			String beans[] = ctx.getBeanDefinitionNames();
			Arrays.sort(beans);
			Arrays.stream(beans)
				.forEach(beanDefinitionName -> {
					System.out.println(beanDefinitionName);
				});
		};
	}

}
