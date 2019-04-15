package com.capgemini.spring.mvc.model.service;

import java.util.List;

import com.capgemini.spring.mvc.model.entity.Person;

public interface PersonService {
	void addNew(Person person);
	List<Person> getAll();
	void update(Person person);
	void delete(int personId);
	Person getPersond(int personId);
}
