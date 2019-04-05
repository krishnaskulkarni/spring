package com.capgemini.spring.client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.capgemini.spring.model.*;

public class OrganizationMain{

	public static void main(String args[]){
		
		ApplicationContext context=new ClassPathXmlApplicationContext("context.xml");
		Organization org=(Organization)context.getBean("organization");
		System.out.println(org);
	}
}