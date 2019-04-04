package com.capgemini.spring.provider;

public class GmMessageProvider implements MessageProvider{
	
	@Override
	public String getMessage(){
		return "good morning";
	}
}
