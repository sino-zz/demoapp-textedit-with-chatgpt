package com.sample.texteditapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sample.texteditapp.dto.Command;
import com.sample.texteditapp.dto.Output;
import com.sample.texteditapp.dto.chatgpt.ChatGptEditsResponse;
import com.sample.texteditapp.service.helper.ApiServiceHelper;

@Service
public class AppServiceImpl implements AppService{

	@Autowired
	ApiServiceHelper apiServiceHelper;
	
	@Autowired
	ChatgptInteractionService chatgptInteractionService;
	
	@Value("${chatgpt.path}")
	private String reqPath;
	
	@Override
	public Output processEdits( Command command) {
		
		String reqBody = apiServiceHelper.buildReq(command);
		
		//ChatGptEditsResponse response = chatgptInteractionService.submitRequest(reqPath, reqBody, ChatGptEditsResponse.class);
		
		//Output output =apiServiceHelper.buildOutput(response);
		
		Output out = new Output();
		out.setText("Hi There, ");
		return out;
	}

}
