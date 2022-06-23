package com.axonactive.coffeeshopmanagement.service;

import com.axonactive.coffeeshopmanagement.exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.controller.request.CustomerRequest;
import com.axonactive.coffeeshopmanagement.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getAll();

    Customer createCustomer(CustomerRequest requestCustomer);

    Optional<Customer> findCustomer(Integer id);

    void deleteCustomer (Integer id);

    Customer update(Integer id, CustomerRequest customerRequest) throws ResourceNotFoundException;

    Optional<Customer> findByPhoneNumber(String phoneNumber);
}
