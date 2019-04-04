package com.capgemini.spring.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.capgemini.spring.renderer.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test{
	public static void main(String []args){
		ApplicationContext context = new AnnotationConfigApplicationContext(MessageRendererConfiguration.class);		
		MessageRenderer renderer = (MessageRenderer)context.getBean("getMessage",MessageRenderer.class);
		renderer.getMessage();
	}
}