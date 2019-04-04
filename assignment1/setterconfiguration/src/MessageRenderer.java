package com.capgemini.spring.renderer;
import com.capgemini.spring.provider.*;

public class MessageRenderer{
	 public static MessageProvider provider;
	
	public void setMessageProvider(MessageProvider provider){
		this.provider = provider;
	}

	public void getMessage(){ 
	System.out.println(provider.getMessage());
	}
	
}