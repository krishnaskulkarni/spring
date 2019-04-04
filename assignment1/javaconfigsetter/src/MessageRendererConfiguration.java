package com.capgemini.spring.renderer;
import com.capgemini.spring.provider.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageRendererConfiguration{
	
	
	@Bean
	public MessageProvider messageRenderer(){
		return new HwMessageProvider();
	}
	
	@Bean
	public MessageRenderer getMessage(){ 
		MessageRenderer renderer = new MessageRenderer();
		renderer.setMessageRenderer(messageRenderer());
		return renderer;
	}
	
}