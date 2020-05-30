package com.gorygon.mongo.api.dto;

import com.gorygon.mongo.api.model.Employee;
import com.gorygon.mongo.api.model.Employee.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeToRest {
	private String id;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@Email
	@NotNull
	private String email;
	private int age;
	private Gender gender;

	public EmployeeToRest( Employee employee ) {
		id = employee.getId();
		firstName = employee.getFirstName();
		lastName = employee.getLastName();
		email = employee.getEmail();
		age = employee.getAge();
		gender = employee.getGender();
	}

	public Employee toEntity() {
		return new Employee(id, firstName, lastName, email, age, gender);
	}
}
