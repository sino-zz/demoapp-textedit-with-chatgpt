package com.sample.texteditapp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatgptInteractionService {
	
	private static final Logger LOGGER = LogManager.getLogger(ChatgptInteractionService.class);

	
	@Value("${chatgpt.domain}")
	private String chatgptDomain;
	
	@Value("${chatgpt.secret}")
	private String chatgptSecret;
	
	public <T> T submitRequest(String reqPath, String reqBody, Class<T> responseType) {
		
		HttpHeaders httpHeaders = getHeaders();
		
		HttpEntity<String> reqEntity = new HttpEntity<>(reqBody,httpHeaders);
		
		
		ResponseEntity<T> responseEntity = submitRequest(HttpMethod.POST,reqEntity,reqPath, responseType);
		
		
		
		
		return responseEntity != null ? responseEntity.getBody() : null;
	}
	
	
	private <T> ResponseEntity<T> submitRequest(HttpMethod httpMethod, HttpEntity<String> reqEntity, String reqPath, Class<T> responseType) {

		ResponseEntity<T> response = null;
		try {
		
		RestTemplate restTemp = new RestTemplate();
		
		if(HttpMethod.POST.equals(httpMethod)) {
			response = restTemp.postForEntity(chatgptDomain+reqPath, reqEntity, responseType);

		}
		
		} catch(Exception e) {
			LOGGER.error(e);	
		}
		return response;
		
	}


	private HttpHeaders getHeaders() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.add(HttpHeaders.AUTHORIZATION, "Bearer " + chatgptSecret);
		
		return header;
	}

}
