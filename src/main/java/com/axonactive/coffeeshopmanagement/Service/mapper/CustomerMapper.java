package com.axonactive.coffeeshopmanagement.Service.mapper;

import com.axonactive.coffeeshopmanagement.Service.dto.CustomerDto;
import com.axonactive.coffeeshopmanagement.entities.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);
    List<CustomerDto> toDtos(List<Customer> customers);
}
