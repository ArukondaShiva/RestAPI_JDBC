package com.example.JdbcExample.dtos;

//import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.example.JdbcExample.model.Person;

import lombok.Data;

@Data
public class CreatePersonDto {

	@NotBlank(message="First Name Should Not be Empty")
	private String firstName;
	private String lastName;
	
	@NotBlank(message="DOB Should Not be Empty")
	private String dob;
	
	public Person to() {
		return Person.builder()
				.firstName(firstName)
				.lastName(lastName)
				.dob(dob).build();
	}
	
}


