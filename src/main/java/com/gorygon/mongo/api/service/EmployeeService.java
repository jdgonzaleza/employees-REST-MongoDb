package com.gorygon.mongo.api.service;

import com.gorygon.mongo.api.model.Employee;
import com.gorygon.mongo.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class EmployeeService implements IEmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(String id) throws ChangeSetPersister.NotFoundException {
		return employeeRepository.findById(id)
						.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) throws ChangeSetPersister.NotFoundException {
		Employee dbEmployee = getEmployeeById(employee.getId());
		employee.mergeForUpdate(dbEmployee);
		return employee;
	}

	@Override
	public void deleteEmployee(String id) throws ChangeSetPersister.NotFoundException {
		employeeRepository.findById(id)
						.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
		employeeRepository.deleteById(id);
	}
}
