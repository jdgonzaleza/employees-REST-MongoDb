package com.gorygon.mongo.api.controller;

import com.gorygon.mongo.api.dto.EmployeeToRest;
import com.gorygon.mongo.api.model.Employee;
import com.gorygon.mongo.api.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees/")
public class EmployeesController extends AbstractRestController<EmployeeToRest, Employee> {
	@Autowired
	IEmployeeService employeeService;

	@PostMapping("")
	public ResponseEntity<EmployeeToRest> createEmployee(@Valid @RequestBody EmployeeToRest employee) {
		EmployeeToRest createdEmployee = toDTO(employeeService.createEmployee(toEntity(employee)));
		return new ResponseEntity<>(createdEmployee, HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<List<EmployeeToRest>> getAllEmployees() {
		List<EmployeeToRest> responseList = employeeService.getAllEmployees().stream()
						.map(this::toDTO).collect(Collectors.toList());
		return new ResponseEntity<>(responseList, HttpStatus.OK);
	}

	@GetMapping("{idEmployee}")
	public ResponseEntity<EmployeeToRest> getEmployeeById(@PathVariable(value = "idEmployee") String idEmployee) throws ChangeSetPersister.NotFoundException {
		EmployeeToRest employee = toDTO(employeeService.getEmployeeById(idEmployee));
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PatchMapping("{idEmployee}")
	public ResponseEntity<EmployeeToRest> updateEmployee(@PathVariable(value = "idEmployee")
					                                               String idEmployee, @RequestBody EmployeeToRest employee) throws ChangeSetPersister.NotFoundException {
		employee.setId(idEmployee);
		EmployeeToRest updatedEmployee = toDTO(employeeService.updateEmployee(toEntity(employee)));
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

	@DeleteMapping("{idEmployee}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value = "idEmployee") String idEmployee) throws ChangeSetPersister.NotFoundException {
		employeeService.deleteEmployee(idEmployee);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@Override
	protected Employee toEntity(EmployeeToRest dto) {
		return dto.toEntity();
	}

	@Override
	protected EmployeeToRest toDTO(Employee employee) {
		return new EmployeeToRest(employee);
	}
}
