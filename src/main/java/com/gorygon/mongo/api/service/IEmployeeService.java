package com.gorygon.mongo.api.service;

import com.gorygon.mongo.api.model.Employee;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface IEmployeeService {
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(String id) throws ChangeSetPersister.NotFoundException;
	public Employee createEmployee(Employee employee);
	public Employee updateEmployee(Employee employee) throws ChangeSetPersister.NotFoundException;
	public void deleteEmployee(String id) throws ChangeSetPersister.NotFoundException;
}
