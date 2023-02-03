package com.sample.texteditapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sample.texteditapp.dto.Command;
import com.sample.texteditapp.service.helper.ApiServiceHelper;

@Service
public class AppServiceImpl implements AppService{

	@Autowired
	ApiServiceHelper apiServiceHelper;
	
	@Autowired
	ChatgptInteractionService chatgptInteractionService;
	
	@Value("@{chatgpt.path}")
	private String reqPath;
	
	@Override
	public String processEdits( Command command) {
		
		String reqBody = apiServiceHelper.buildReq(command);
		
		chatgptInteractionService.submitRequest(reqPath, reqBody, null);
		
		return null;
	}

}
