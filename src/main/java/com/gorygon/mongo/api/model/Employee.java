package com.gorygon.mongo.api.model;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employees")
public class Employee {
	@Id
	private String id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private Integer age;
	@NotBlank
	private Gender gender;

	public void mergeForUpdate(Employee dbEmployee) {
		if (id == null)
			id = dbEmployee.getId();
		if (firstName == null)
			firstName = dbEmployee.getId();
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
