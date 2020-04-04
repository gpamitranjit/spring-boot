package com.amit.app.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

/**
*
* @author Amit Patil
*
**/
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private HomeController homeController;
	
	@Test
	public void controller_existance_test() {
		assertThat(homeController).isNotNull();
	}
	
	@Test
	public void greetingShouldReturnHardcodedMessage() {
		assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/", String.class))
			.isEqualTo("Hello, World");
	}
}
