package com.capgemini.spring.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import com.capgemini.spring.provider.*;
import com.capgemini.spring.render.*;
 
@Lazy
@Configuration
public class MessageConfig {
 	
	@Bean
	public MessageProvider provider(){
		
		System.out.println("provider....");
		return new HWMessageProvider();
	}

	@Bean
	public MessageRender render(){
		MessageRender render=new MessageRender();
		render.setMessageRender(provider());
		System.out.println("render....");
		return render; 
	}
}