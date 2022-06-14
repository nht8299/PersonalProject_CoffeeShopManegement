package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.CustomerService;
import com.axonactive.coffeeshopmanagement.Service.dto.CustomerDto;
import com.axonactive.coffeeshopmanagement.Service.mapper.CustomerMapper;
import com.axonactive.coffeeshopmanagement.api.request.CustomerRequest;
import com.axonactive.coffeeshopmanagement.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(CustomerResource.PATH)
public class CustomerResource {

    public static final String PATH = "/api/customer";

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerMapper customerMapper;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        return ResponseEntity.ok(customerMapper.toDtos(customerService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable(value = "id") Integer id, @PathVariable(value = "phoneNumber", required = false) String phoneNumber) throws NotFoundException {
        if (null == phoneNumber) {
            return ResponseEntity.ok(customerMapper.toDto(customerService.findCustomer(id)
                    .orElseThrow(() -> new NotFoundException("Customer not found: " + id))));
        }return ResponseEntity.ok((customerMapper.toDto(customerService.findByPhoneNumber(phoneNumber).orElseThrow(() -> new NotFoundException("Customer not found: "+phoneNumber)))));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> add(@RequestBody Customer requestCustomer) {
        Customer newCustomer = new Customer();
        newCustomer.setFullName(requestCustomer.getFullName());
        newCustomer.setAddress(requestCustomer.getAddress());
        newCustomer.setPhoneNumber(requestCustomer.getPhoneNumber());
        newCustomer.setFeedBack(requestCustomer.getFeedBack());
        Customer createCustomer = customerService.createCustomer(newCustomer);
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
    public ResponseEntity<CustomerDto> update(@PathVariable(value = "id") Integer id, @RequestBody CustomerRequest requestCustomer) throws NotFoundException {
        Customer updateCustomer = new Customer();
        updateCustomer.setFullName(requestCustomer.getFullName());
        updateCustomer.setPhoneNumber(requestCustomer.getPhoneNumber());
        updateCustomer.setAddress(requestCustomer.getAddress());
        updateCustomer.setFeedBack(requestCustomer.getFeedBack());
        return ResponseEntity.ok(customerMapper.toDto(customerService.update(id, updateCustomer)));
    }
}
