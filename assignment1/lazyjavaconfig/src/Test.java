package com.capgemini.spring.test;
import com.capgemini.spring.render.*; 
import org.springframework.context.annotation.*;
import org.springframework.context.*;
import com.capgemini.spring.config.*;


public class Test{
	public static void  main(String args[]){
		ApplicationContext context=new AnnotationConfigApplicationContext(MessageConfig.class);
		System.out.println("main....");
		MessageRender render=(MessageRender)context.getBean("render");
		render.displayMessage();
		MessageRender render1=(MessageRender)context.getBean("render");

		if(render.equals(render1)){
			System.out.println("Singleton..");
		}else{
			System.out.println(" Not Singleton..");
		}
	}
}