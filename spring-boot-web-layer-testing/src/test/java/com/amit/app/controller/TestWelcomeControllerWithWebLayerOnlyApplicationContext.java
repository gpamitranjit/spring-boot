package com.amit.app.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

/**
*
* @author Amit Patil
*
* @apiNote
* By using @{@link WebMvcTest} annotation we are making sure that only the web layer application context is prepared
* rather than preparing whole application context as with @{@link SpringBootTest} & @{@link AutoConfigureMockMvc} annotation
**/
@WebMvcTest
public class TestWelcomeControllerWithWebLayerOnlyApplicationContext {

	@Autowired
	private MockMvc mockmvc;
	
	@Test
	public void test_welcomeMessage_handle() throws Exception {
		this.mockmvc
			.perform(get("/"))
			.andDo(print())
			.andExpect(content().string(is("Welcome")));
	}
}
