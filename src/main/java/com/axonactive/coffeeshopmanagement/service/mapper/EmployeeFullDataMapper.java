package com.axonactive.coffeeshopmanagement.service.mapper;


import com.axonactive.coffeeshopmanagement.entities.Employee;
import com.axonactive.coffeeshopmanagement.service.dto.EmployeeFullDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeFullDataMapper {

    @Mapping(target = "coffeeShopId",source = "employee.coffeeShop.id")

    EmployeeFullDataDto toDto(Employee employee);
    List<EmployeeFullDataDto> toDtos(List<Employee> employees);
}