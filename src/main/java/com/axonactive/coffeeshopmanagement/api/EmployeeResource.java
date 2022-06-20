package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.service.CoffeeShopService;
import com.axonactive.coffeeshopmanagement.service.EmployeeService;
import com.axonactive.coffeeshopmanagement.service.dto.EmployeeDto;
import com.axonactive.coffeeshopmanagement.service.mapper.EmployeeMapper;
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

    public static final String PATH="/api/employees";

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
                                                        @PathVariable(value = "phoneNumber",required = false)String phoneNumber) throws ResourceNotFoundException {
        if ( null == phoneNumber ){
        return ResponseEntity.ok(employeeMapper.toDto(employeeService.findEmployee(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found: "+ id))));}
        return ResponseEntity.ok(employeeMapper.toDto(employeeService.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found: "+phoneNumber))));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> add(@RequestBody EmployeeRequest requestEmployee) throws ResourceNotFoundException {

        Employee createEmployee = employeeService.createEmployee(requestEmployee);
        return ResponseEntity.created(URI.create(EmployeeResource.PATH +"/"+createEmployee.getId()))
                .body(employeeMapper.toDto(createEmployee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id")String id,@PathVariable(value = "phoneNumber",required = false)String phoneNumber) throws ResourceNotFoundException {
        if (null == phoneNumber) {
            employeeService.deleteEmployee(id);
        }else {
            employeeService.deleteEmployee(employeeService.findByPhoneNumber(phoneNumber)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found with phone number: " + phoneNumber)).getId());
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable(value = "id")String id,@RequestBody EmployeeRequest requestEmployee) throws ResourceNotFoundException {
        return ResponseEntity.ok(employeeMapper.toDto(employeeService.update(id,requestEmployee)));
    }
}
