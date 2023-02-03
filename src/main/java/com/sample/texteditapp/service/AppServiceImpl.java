package com.sample.texteditapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.texteditapp.dto.Command;
import com.sample.texteditapp.service.helper.ApiServiceHelper;

@Service
public class AppServiceImpl implements AppService{

	@Autowired
	ApiServiceHelper apiServiceHelper;
	
	
	@Override
	public String processEdits( Command command) {
		
		String reqBody = apiServiceHelper.buildReq(command);
		
		
		return null;
	}

}
