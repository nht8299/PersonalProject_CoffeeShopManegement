package com.axonactive.coffeeshopmanagement.service;

import com.axonactive.coffeeshopmanagement.exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.controller.request.EmployeeRequest;
import com.axonactive.coffeeshopmanagement.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAll();

    Employee createEmployee(EmployeeRequest requestEmployee) throws ResourceNotFoundException;

    Optional<Employee> findEmployee(String id);

    void deleteEmployee(String id);

    Employee update(String id,EmployeeRequest requestEmployee) throws ResourceNotFoundException;

    Optional<Employee> findByPhoneNumber (String phoneNumber);
}
