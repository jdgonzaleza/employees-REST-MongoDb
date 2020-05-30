package com.gorygon.mongo.api.dto;

import com.gorygon.mongo.api.model.Employee.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeToRest {
	private String id;
	private String name;
	private String lastName;
	private String email;
	private int age;
	private Gender gender;
}
