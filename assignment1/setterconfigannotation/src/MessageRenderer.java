package com.capgemini.spring.renderer;
import com.capgemini.spring.provider.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service("messageRenderer")
public class MessageRenderer{
	 public static MessageProvider provider;
	
	@Autowired
	public void getMessageRenderer(MessageProvider provider){
		this.provider = provider;
	}

	public void getMessage(){ 
	System.out.println(provider.getMessage());
	}
	
}