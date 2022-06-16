package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.CoffeeShopService;
import com.axonactive.coffeeshopmanagement.Service.EmployeeService;
import com.axonactive.coffeeshopmanagement.Service.dto.EmployeeDto;
import com.axonactive.coffeeshopmanagement.Service.mapper.EmployeeMapper;
import com.axonactive.coffeeshopmanagement.api.request.EmployeeRequest;
import com.axonactive.coffeeshopmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(value = "3600")
@RestController
@RequestMapping(EmployeeResource.PATH)
public class EmployeeResource {

    public static final String PATH="/api/employee";

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CoffeeShopService coffeeShopService;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAll(){
        return ResponseEntity.ok(employeeMapper.toDtos(employeeService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable(value = "id")String id,
                                                        @PathVariable(value = "phoneNumber",required = false)String phoneNumber) throws NotFoundException {
        if ( null == phoneNumber ){
        return ResponseEntity.ok(employeeMapper.toDto(employeeService.findEmployee(id)
                .orElseThrow(() -> new NotFoundException("Employee not found: "+ id))));}
        return ResponseEntity.ok(employeeMapper.toDto(employeeService.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new NotFoundException("Employee not found: "+phoneNumber))));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> add(@RequestBody EmployeeRequest requestEmployee) throws NotFoundException {
        Employee newEmployee = new Employee();
        newEmployee.setAddress(requestEmployee.getAddress());
        newEmployee.setGender(requestEmployee.getGender());
        newEmployee.setCoffeeShop(coffeeShopService.findCoffeeShop(requestEmployee.getCoffeeShopId())
                .orElseThrow(() -> new NotFoundException("CoffeeShop not found: "+requestEmployee.getCoffeeShopId())));
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
        Employee createEmployee = employeeService.createEmployee(newEmployee);
        return ResponseEntity.created(URI.create(EmployeeResource.PATH +"/"+createEmployee.getId()))
                .body(employeeMapper.toDto(createEmployee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id")String id,@PathVariable(value = "phoneNumber",required = false)String phoneNumber) throws NotFoundException {
        if (null == phoneNumber) {
            employeeService.deleteEmployee(id);
        }
            employeeService.deleteEmployee(employeeService.findByPhoneNumber(phoneNumber)
                    .orElseThrow(() -> new NotFoundException("Employee not found with phone number: "+phoneNumber)).getId());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable(value = "id")String id,@RequestBody EmployeeRequest requestEmployee) throws NotFoundException {
        Employee updateEmployee = new Employee();
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
                .orElseThrow(() -> new NotFoundException("CoffeeShop not found: " + requestEmployee.getCoffeeShopId())));
        return ResponseEntity.ok(employeeMapper.toDto(employeeService.update(id,updateEmployee)));
    }
}
