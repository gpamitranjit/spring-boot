package com.amit.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.amit.app.model.managed.User;
import com.amit.app.repository.UserRepository;

@SpringBootApplication
@EnableCaching
public class SpringBootCachingWithRedisApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootCachingWithRedisApplication.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCachingWithRedisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Populating some sample user data in database.");
		userRepository.save(new User("Amit", 2));
		userRepository.save(new User("Ranjit", 30));
		userRepository.save(new User("Sachin", 60));
		userRepository.save(new User("Tanajirao", 90));
		logger.info("Population of sample user data completed in database.");
	}
}
