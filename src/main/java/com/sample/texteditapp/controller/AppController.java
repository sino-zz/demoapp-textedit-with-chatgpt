package com.sample.texteditapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.texteditapp.dto.Command;
import com.sample.texteditapp.service.AppService;

@RestController
@RequestMapping("/api/vi/texteditapp")
public class AppController {
	
	private static final Logger LOGGER = LogManager.getLogger(AppController.class);
	
	@Autowired
	AppService appservice;
	
	
	@PostMapping("/edits")
	public String createEdits(@RequestBody Command command) {
		LOGGER.info("Parameters: {} ",command);
		String result =  null;
		try {
			result = appservice.processEdits(command);
		
		return null;
		} finally {
			LOGGER.info("return: {} ",result );	
		}
		
		
	}
	
	

}
