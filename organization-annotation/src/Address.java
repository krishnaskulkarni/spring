package com.capgemini.spring.model;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
public class Address{
	@Value("pune")
	private String cityName;
	@Value("maharashtra")
	private String stateName;

	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString(){
		return "[ city ="+cityName+", state="+stateName+"]";
	}
	
}
