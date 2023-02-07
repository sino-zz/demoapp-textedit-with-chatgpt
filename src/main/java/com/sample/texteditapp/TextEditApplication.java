package com.sample.texteditapp;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TextEditApplication {

	private static final Logger LOGGER = LogManager.getLogger(TextEditApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TextEditApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			LOGGER.info("Beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				LOGGER.info(beanName);
			}

		};
	}

}
