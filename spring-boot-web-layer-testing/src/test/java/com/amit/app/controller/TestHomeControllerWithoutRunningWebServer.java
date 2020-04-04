package com.amit.app.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
*
* @author Amit Patil
*
* @apiNote
* using @AutoConfigureMockMvc we are instructing spring to not create web server,
* to handle the incoming request rather let spring do it for you and handover the
* request at controller layer
* Note the whole spring application context is created in this case.
**/
@SpringBootTest
@AutoConfigureMockMvc
public class TestHomeControllerWithoutRunningWebServer {

	@Autowired
	private MockMvc mockmvc;
	
	@Test
	public void homeControllerShouldReturnHardcodedMessage() throws Exception {
		this.mockmvc
				.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, World")));
	}
}
