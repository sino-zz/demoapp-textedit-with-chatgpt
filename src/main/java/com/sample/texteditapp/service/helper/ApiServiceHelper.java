package com.sample.texteditapp.service.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.texteditapp.dto.Command;

@Service
public class ApiServiceHelper {

	private static final Logger LOGGER = LogManager.getLogger(ApiServiceHelper.class);

	
	
	@Value("${app.default.model}")
	private String defaultModel;
	
	public String buildReq(Command command) {
		String response = null;
		
		ChatGptEditsReq req = new ChatGptEditsReq();
		req.setModel(defaultModel);
		req.setInput(command.getInput());
		req.setInstruction(command.getInstruction());
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		
		try {
			response =  mapper.writeValueAsString(req);
		} catch (JsonProcessingException e) {
			LOGGER.error(e);
		}
		
		return response;
	}
	
	
	class ChatGptEditsReq {
		private String model;
		
		private String input ;
		
		private String instruction;

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getInput() {
			return input;
		}

		public void setInput(String input) {
			this.input = input;
		}

		public String getInstruction() {
			return instruction;
		}

		public void setInstruction(String instruction) {
			this.instruction = instruction;
		}
		
		
	}

}
