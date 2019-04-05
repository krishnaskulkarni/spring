package com.capgemini.spring.renderer;
import com.capgemini.spring.provider.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class MessageRenderer{
	 public static MessageProvider provider;
	
	@Autowired
	public MessageRenderer(MessageProvider provider){
		System.out.println("renderre class");
		this.provider = provider;
	}

	public void getMessage(){ 
		System.out.println("display msg ");
	System.out.println(provider.getMessage());
	}
	
}