package com.axonactive.coffeeshopmanagement.api.request;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.EmployeeService;
import com.axonactive.coffeeshopmanagement.Service.dto.EmployeeDto;
import com.axonactive.coffeeshopmanagement.Service.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EmployeeResource.PATH)
public class EmployeeResource {

    public static final String PATH="/api/employee";

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAll(){
        return ResponseEntity.ok(employeeMapper.toDtos(employeeService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable(value = "id")String id) throws NotFoundException {
        return ResponseEntity.ok(employeeMapper.toDto(employeeService.findEmployee(id)
                .orElseThrow(() -> new NotFoundException("Employee not found: "+ id))));
    }

    @PostMapping

}
