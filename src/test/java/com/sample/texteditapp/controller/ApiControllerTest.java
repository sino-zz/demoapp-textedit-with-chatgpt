package com.sample.texteditapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {
	
	private static final Logger LOGGER = LogManager.getLogger(ApiControllerTest.class);
	
	
	@Autowired
	private MockMvc mvc;

	@Test
	public void getHello() throws Exception {
		/*
		 * mvc.perform(MockMvcRequestBuilders.get("/api/v1/texteditapp").accept(
		 * MediaType.APPLICATION_JSON)) .andExpect(status().isOk())
		 * .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
		 */
	}
	

	
	

}
