package com.capgemini.spring.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.spring.mvc.model.dao.PersonDao;
import com.capgemini.spring.mvc.model.entity.Person;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonDao dao;
	
	@Override
	public void addNew(Person person) {
		dao.addNew(person);
		
	}

	@Override
	public List<Person> getAll() {
		
		return null;
	}

	@Override
	public void update(Person person) {
		
		
	}

	@Override
	public void delete(int personId) {
		
		
	}

	@Override
	public Person getPersond(int personId) {
		
		return null;
	}
	
}
