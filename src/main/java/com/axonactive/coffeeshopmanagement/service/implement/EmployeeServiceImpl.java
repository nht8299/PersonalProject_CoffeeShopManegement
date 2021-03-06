package com.axonactive.coffeeshopmanagement.service.implement;

import com.axonactive.coffeeshopmanagement.exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.service.CoffeeShopService;
import com.axonactive.coffeeshopmanagement.service.EmployeeService;
import com.axonactive.coffeeshopmanagement.controller.request.EmployeeRequest;
import com.axonactive.coffeeshopmanagement.entities.Employee;
import com.axonactive.coffeeshopmanagement.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final CoffeeShopService coffeeShopService;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(EmployeeRequest requestEmployee) throws ResourceNotFoundException {
        Employee newEmployee = new Employee();
        newEmployee.setAddress(requestEmployee.getAddress());
        newEmployee.setGender(requestEmployee.getGender());
        newEmployee.setCoffeeShop(coffeeShopService.findCoffeeShop(requestEmployee.getCoffeeShopId())
                .orElseThrow(() -> new ResourceNotFoundException("CoffeeShop not found: "+requestEmployee.getCoffeeShopId())));
        newEmployee.setIdentity(requestEmployee.getIdentity());
        newEmployee.setId(requestEmployee.getId());
        newEmployee.setFirstName(requestEmployee.getFirstName());
        newEmployee.setLastName(requestEmployee.getLastName());
        newEmployee.setMiddleName(requestEmployee.getMiddleName());
        newEmployee.setPhoneNumber(requestEmployee.getPhoneNumber());
        newEmployee.setStartDate(requestEmployee.getStartDate());
        newEmployee.setDateOfBirth(requestEmployee.getDateOfBirth());
        newEmployee.setRole(requestEmployee.getRole());
        newEmployee.setType(requestEmployee.getType());
        newEmployee.setStatus(requestEmployee.getStatus());
        return employeeRepository.save(newEmployee);
    }

    @Override
    public Optional<Employee> findEmployee(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee update(String id, EmployeeRequest requestEmployee) throws ResourceNotFoundException {
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found: "+ id));
        updateEmployee.setMiddleName(requestEmployee.getMiddleName());
        updateEmployee.setLastName(requestEmployee.getLastName());
        updateEmployee.setFirstName(requestEmployee.getFirstName());
        updateEmployee.setAddress(requestEmployee.getAddress());
        updateEmployee.setIdentity(requestEmployee.getIdentity());
        updateEmployee.setPhoneNumber(requestEmployee.getPhoneNumber());
        updateEmployee.setGender(requestEmployee.getGender());
        updateEmployee.setStartDate(requestEmployee.getStartDate());
        updateEmployee.setRole(requestEmployee.getRole());
        updateEmployee.setType(requestEmployee.getType());
        updateEmployee.setStatus(requestEmployee.getStatus());
        updateEmployee.setCoffeeShop(coffeeShopService.findCoffeeShop(requestEmployee.getCoffeeShopId())
                .orElseThrow(() -> new ResourceNotFoundException("CoffeeShop not found: " + requestEmployee.getCoffeeShopId())));
        return employeeRepository.save(updateEmployee);
    }

    @Override
    public Optional<Employee> findByPhoneNumber(String phoneNumber) {
        return employeeRepository.findByPhoneNumber(phoneNumber);
    }
}
