package com.capgemini.spring.provider;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class GmMessageProvider implements MessageProvider{
	
	@Override
	public String getMessage(){
		return "good morning";
	}
}
