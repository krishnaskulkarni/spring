package com.capgemini.spring.provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("provider")
public class GmMessageProvider implements MessageProvider{
	
	@Override
	public String getMessage(){
		return "good morning";
	}
}
