package com.sample.texteditapp.dto;

public class Command {

	private String input;
	
	private String instruction;

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

	@Override
	public String toString() {
		return "Command [input=" + input + ", instruction=" + instruction + "]";
	}
	
	
}
