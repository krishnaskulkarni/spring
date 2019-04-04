package com.capgemini.spring.provider;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;


@Component
public class HwMessageProvider implements MessageProvider{
	
	@Override
	public String getMessage(){
		return "Hello World";
	}
}