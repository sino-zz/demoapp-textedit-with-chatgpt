package com.sample.texteditapp.service.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.texteditapp.dto.Command;
import com.sample.texteditapp.dto.Output;
import com.sample.texteditapp.dto.chatgpt.ChatGptEditsReq;
import com.sample.texteditapp.dto.chatgpt.ChatGptEditsResponse;

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

	public Output buildOutput(ChatGptEditsResponse response) {
		
		Output output = new Output();
		
		if(response != null && !response.getChoices().isEmpty()) {
			output.setText(response.getChoices().get(0).getText());

		}
		return output;
	}
	
	
	

}
