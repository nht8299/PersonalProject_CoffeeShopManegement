package com.axonactive.coffeeshopmanagement.Service.implement;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.CustomerService;
import com.axonactive.coffeeshopmanagement.entities.Customer;
import com.axonactive.coffeeshopmanagement.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findCustomer(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer update(Integer id, Customer customerDetails) throws NotFoundException {
        Customer updateCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found: "+ id));
        updateCustomer.setFullName(customerDetails.getFullName());
        updateCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
        updateCustomer.setAddress(customerDetails.getAddress());
        updateCustomer.setFeedBack(customerDetails.getFeedBack());
        return customerRepository.save(updateCustomer);
    }

    @Override
    public Optional<Customer> findByPhoneNumber(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber);
    }
}
