package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAll();

    Employee createEmployee(Employee employee);

    Optional<Employee> findEmployee(String id);

    void deleteEmployee(String id);
}
