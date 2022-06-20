package com.axonactive.coffeeshopmanagement.service.mapper;

import com.axonactive.coffeeshopmanagement.service.dto.EmployeeDto;
import com.axonactive.coffeeshopmanagement.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "fullName",expression = "java(employee.getFirstName() + \" \" +employee.getMiddleName()+ \" \" +employee.getLastName())")
    @Mapping(source = "employee.coffeeShop.name",target = "coffeeShopName")
    EmployeeDto toDto(Employee employee);

    List<EmployeeDto> toDtos(List<Employee> employees);
}
