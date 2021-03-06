package com.axonactive.coffeeshopmanagement.service.mapper;

import com.axonactive.coffeeshopmanagement.service.dto.CustomerDto;
import com.axonactive.coffeeshopmanagement.entities.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);
    List<CustomerDto> toDtos(List<Customer> customers);
}
