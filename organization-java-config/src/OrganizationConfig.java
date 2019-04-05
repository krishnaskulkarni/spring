package com.capgemini.spring.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.capgemini.spring.model.*;
import java.util.*;
import java.io.*;

@Configuration
public class OrganizationConfig{
	
	@Bean
	public Organization getOrganization(){
		Organization org = new Organization(101,"capgemini",12000,address(),directors(),branches(),branchWiseHead(),getIpAddress(),getDatabase());
		return org;
	}
	
	public List<String> directors(){
		List<String> directors = new ArrayList<String>();		
		directors.add("john");
		directors.add("ricky");
		return directors;
	}	

	
	public Address address(){
		return new Address("pune","maharashtra");
	}
	
	public Set<String> branches(){
		Set<String> branches = new TreeSet<String>();
		branches.add("Airoli");
		branches.add("pune");
		return branches;
	}
	
	public Map<String,String> branchWiseHead(){
		Map<String,String> branchwiseHead = new HashMap<String,String>();
		branchwiseHead.put("airoli","spyderman");
		branchwiseHead.put("pune","superrman");
		return branchwiseHead;
	}
	
	public Properties getIpAddress(){
		Properties ipAddress = null;
		try{
		FileReader reader = new FileReader("src/myProperties1.properties");		
		ipAddress = new Properties();
		ipAddress.load(reader);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return ipAddress;
	}
	
	public Properties getDatabase(){
		Properties database = null;
		try{
		FileReader reader = new FileReader("src/myProperties2.properties");		
		database = new Properties();
		database.load(reader);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return database;
	}

}