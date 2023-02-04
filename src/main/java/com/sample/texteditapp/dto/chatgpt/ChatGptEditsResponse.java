package com.sample.texteditapp.dto.chatgpt;

import java.util.List;

public class ChatGptEditsResponse {

	private String object;
	
	private String created;
	
	private List<Choice> choices;
	
	private Usage usage;

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	public Usage getUsage() {
		return usage;
	}

	public void setUsage(Usage usage) {
		this.usage = usage;
	}
	
	 
	
}

 
