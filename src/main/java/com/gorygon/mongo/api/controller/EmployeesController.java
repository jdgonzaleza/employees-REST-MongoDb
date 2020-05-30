package com.gorygon.mongo.api.controller;

import com.gorygon.mongo.api.model.Employee;
import com.gorygon.mongo.api.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees/")
public class EmployeesController {
	@Autowired
	IEmployeeService employeeService;

	@PostMapping("")
	public Employee createEmployee(@Validated @RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@GetMapping("")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
	}

	@GetMapping("{idEmployee}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "idEmployee") String idEmployee) throws ChangeSetPersister.NotFoundException {
		return new ResponseEntity<>(employeeService.getEmployeeById(idEmployee), HttpStatus.OK);
	}

	@PatchMapping("{idEmployee}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "idEmployee")
					                                               String idEmployee, @RequestBody Employee employeee) throws ChangeSetPersister.NotFoundException {
		employeee.setId(idEmployee);
		return new ResponseEntity<>(employeeService.updateEmployee(employeee), HttpStatus.OK);
	}

	@DeleteMapping("{idEmployee}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value = "idEmployee") String idEmployee) throws ChangeSetPersister.NotFoundException {
		employeeService.deleteEmployee(idEmployee);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
