package com.axonactive.coffeeshopmanagement.Service.implement;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.EmployeeService;
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

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
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
    public Employee update(String id, Employee requestEmployee) throws NotFoundException {
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found: "+ id));
        updateEmployee.setGender(requestEmployee.getGender());
        updateEmployee.setStartDate(requestEmployee.getStartDate());
        updateEmployee.setCoffeeShop(requestEmployee.getCoffeeShop());
        updateEmployee.setPhoneNumber(requestEmployee.getPhoneNumber());
        updateEmployee.setAddress(requestEmployee.getAddress());
        updateEmployee.setIdentity(requestEmployee.getIdentity());
        updateEmployee.setFirstName(requestEmployee.getFirstName());
        updateEmployee.setMiddleName(requestEmployee.getMiddleName());
        updateEmployee.setLastName(requestEmployee.getLastName());
        return employeeRepository.save(updateEmployee);
    }

    @Override
    public Optional<Employee> findByPhoneNumber(String phoneNumber) {
        return employeeRepository.findByPhoneNumber(phoneNumber);
    }
}
