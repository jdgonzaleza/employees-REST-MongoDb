package com.gorygon.mongo.api.repository;

import com.gorygon.mongo.api.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
