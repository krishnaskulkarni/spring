package com.capgemini.spring.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.capgemini.spring.renderer.*;

public class Test{
	public static void main(String []args){
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");	
		System.out.println("main class");		
		MessageRenderer renderer = (MessageRenderer)context.getBean(MessageRenderer.class);
		renderer.getMessage();
		MessageRenderer renderer1 = (MessageRenderer)context.getBean(MessageRenderer.class);
		if(renderer.equals(renderer1)){
			System.out.println("singleton");
		}
		else
			System.out.println("not singleton");
		
	}
}