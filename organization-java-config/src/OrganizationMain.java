
package com.capgemini.spring.client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.capgemini.spring.model.*;
import com.capgemini.spring.configuration.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrganizationMain{

	public static void main(String args[]){
		
		ApplicationContext context=new AnnotationConfigApplicationContext(OrganizationConfig.class);
		Organization org=(Organization)context.getBean("getOrganization");
		System.out.println(org);
	}
}