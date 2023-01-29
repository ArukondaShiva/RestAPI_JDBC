package com.example.JdbcExample.service;

import java.sql.SQLException;
import java.util.List;

import com.example.JdbcExample.dtos.CreatePersonDto;
import com.example.JdbcExample.model.Person;

public interface PersonServiceInterf {

	void createPersonStatic(CreatePersonDto createPersonDto);
	
	Person getPersonById(int id);
	
	Person deletePerson(int id);
	
	List<Person> getAllPersons() throws SQLException;
	
}


