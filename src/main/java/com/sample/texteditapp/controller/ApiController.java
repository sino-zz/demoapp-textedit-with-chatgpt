package com.sample.texteditapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.texteditapp.dto.Command;
import com.sample.texteditapp.dto.Output;
import com.sample.texteditapp.service.AppService;

@RestController
@RequestMapping("/api/v1/texteditapp")
public class ApiController {
	
	private static final Logger LOGGER = LogManager.getLogger(ApiController.class);
	
	@Autowired
	AppService appservice;
	
	
	@PostMapping("/edits")
	public Output createEdits(@RequestBody Command command) {
		LOGGER.info("Parameters: {} ",command);
		Output output =  null;
		try {
			output = appservice.processEdits(command);
		
		return output;
		} finally {
			LOGGER.info("return: {} ",output );	
		}
		
		
	}
	
	

}
