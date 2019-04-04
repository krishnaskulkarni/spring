package com.capgemini.spring.renderer;
import com.capgemini.spring.provider.*;

public class MessageRenderer{
	 public static MessageProvider provider;

	public MessageRenderer(MessageProvider provider){
		this.provider = provider;
	}

	public void getMessage(){ 
	System.out.println(provider.getMessage());
	}
	
}