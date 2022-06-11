package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getAll();

    Customer createCustomer(Customer customer);

    Optional<Customer> findCustomer(Integer id);

    void deleteCustomer (Integer id);

    Customer update(Integer id,Customer customerDetails) throws NotFoundException;
}
