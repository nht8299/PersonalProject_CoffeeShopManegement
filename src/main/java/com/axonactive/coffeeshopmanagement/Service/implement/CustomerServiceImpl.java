package com.axonactive.coffeeshopmanagement.Service.implement;

import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.Service.CustomerService;
import com.axonactive.coffeeshopmanagement.api.request.CustomerRequest;
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
    public Customer createCustomer(CustomerRequest requestCustomer) {
        Customer newCustomer = new Customer();
        newCustomer.setFullName(requestCustomer.getFullName());
        newCustomer.setAddress(requestCustomer.getAddress());
        newCustomer.setPhoneNumber(requestCustomer.getPhoneNumber());
        newCustomer.setFeedBack(requestCustomer.getFeedBack());
        return customerRepository.save(newCustomer);
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
    public Customer update(Integer id, CustomerRequest requestCustomer) throws ResourceNotFoundException {
        Customer updateCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found: "+ id));
        updateCustomer.setFullName(requestCustomer.getFullName());
        updateCustomer.setPhoneNumber(requestCustomer.getPhoneNumber());
        updateCustomer.setAddress(requestCustomer.getAddress());
        updateCustomer.setFeedBack(requestCustomer.getFeedBack());
        return customerRepository.save(updateCustomer);
    }

    @Override
    public Optional<Customer> findByPhoneNumber(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber);
    }
}
