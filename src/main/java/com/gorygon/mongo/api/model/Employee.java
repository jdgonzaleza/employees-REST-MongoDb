package com.gorygon.mongo.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employees")
public class Employee {
	@Id
	private String id;
	private String name;
	private String lastName;
	private String email;
	private Integer age;
	private Gender gender;

	public void mergeForUpdate(Employee dbEmployee) {
		if (id == null)
			id = dbEmployee.getId();
		if (name == null)
			name = dbEmployee.getId();
		if (lastName == null)
			lastName = dbEmployee.getLastName();
		if (email == null)
			email = dbEmployee.getEmail();
		if (age == null)
			age = dbEmployee.getAge();
		if (gender == null)
			gender = dbEmployee.getGender();
	}

	public enum Gender {
		Male,
		Female,
		WhoCares
	}
}
