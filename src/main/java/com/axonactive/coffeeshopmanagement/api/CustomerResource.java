package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.service.CustomerService;
import com.axonactive.coffeeshopmanagement.service.dto.CustomerDto;
import com.axonactive.coffeeshopmanagement.service.mapper.CustomerMapper;
import com.axonactive.coffeeshopmanagement.api.request.CustomerRequest;
import com.axonactive.coffeeshopmanagement.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(value = "3600")
@RestController
@RequestMapping(CustomerResource.PATH)
public class CustomerResource {

    public static final String PATH = "/api/customers";

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerMapper customerMapper;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        return ResponseEntity.ok(customerMapper.toDtos(customerService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable(value = "id") Integer id,
                                                        @RequestParam(value = "phoneNumber", required = false) String phoneNumber) throws ResourceNotFoundException {
        if (null == phoneNumber) {
            return ResponseEntity.ok(customerMapper.toDto(customerService.findCustomer(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + id))));
        }
        return ResponseEntity.ok((customerMapper.toDto(customerService.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + phoneNumber)))));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> add(@RequestBody CustomerRequest requestCustomer) {
        Customer createCustomer = customerService.createCustomer(requestCustomer);
        return ResponseEntity
                .created(URI.create(CustomerResource.PATH + "/" + createCustomer.getId()))
                .body(customerMapper.toDto(createCustomer));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(@PathVariable(value = "id") Integer id,
                                              @RequestBody CustomerRequest requestCustomer) throws ResourceNotFoundException {
        return ResponseEntity.ok(customerMapper.toDto(customerService.update(id, requestCustomer)));
    }

}
