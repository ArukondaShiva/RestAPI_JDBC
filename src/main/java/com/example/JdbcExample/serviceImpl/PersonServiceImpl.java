package com.example.JdbcExample.serviceImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JdbcExample.BadPersonRequestException;
import com.example.JdbcExample.dtos.CreatePersonDto;
import com.example.JdbcExample.model.Person;
import com.example.JdbcExample.repository.PersonRepositoryInterf;
import com.example.JdbcExample.service.PersonServiceInterf;


@Service
public class PersonServiceImpl implements PersonServiceInterf {

	@Autowired
	PersonRepositoryInterf personRepositoryInterf;
	
	@Override
	public void createPersonStatic(CreatePersonDto createPersonDto) {
		 Person person = createPersonDto.to();
		 
		 if(person.getAge()==null) {
			 person.setAge(calculateAgeFromDOB(person.getDob()));
		 }
		 //personRepositoryInterf.createPerson(person);
		 personRepositoryInterf.createPersonStatic(person);
	}
	
	
	private Integer calculateAgeFromDOB(String dob) {
		if(dob==null) {
			return null;
		}
		LocalDate dobDate = LocalDate.parse(dob);
		LocalDate currentDate = LocalDate.now();
		
		return Period.between(dobDate, currentDate).getYears();
	}
	
	

	@Override
	public Person getPersonById(int id) {
	 	return personRepositoryInterf.getPersonById(id);
	}

	
	@Override
	public Person deletePerson(int id) {
		Person person  = personRepositoryInterf.getPersonById(id);
		if(person==null) {
			throw new BadPersonRequestException("Person with id = "+id+" is not Present");
		}
	 	boolean isDeleted = personRepositoryInterf.deletePerson(id);
	 	if(isDeleted) {
	 		return person;
	 	}
	 	
	 	return null;
	}
	

	@Override
	public List<Person> getAllPersons() throws SQLException {
	 	return personRepositoryInterf.getAllPersons();
	}
	

}



