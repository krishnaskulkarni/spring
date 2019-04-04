package com.capgemini.spring.renderer;
import com.capgemini.spring.provider.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;


public class MessageRenderer{
	 public static MessageProvider provider;
	
	public void setMessageRenderer(MessageProvider provider){
		this.provider = provider;
	}

	public void getMessage(){ 
	System.out.println(provider.getMessage());
	}
	
}