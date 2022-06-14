package com.axonactive.coffeeshopmanagement.Service.mapper;

import com.axonactive.coffeeshopmanagement.Service.dto.PaymentDto;
import com.axonactive.coffeeshopmanagement.entities.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    @Mapping(target = "employeeId",source = "payment.employee.id")
    @Mapping(target = "employeeFullName",expression= "java(payment.getEmployee().getFirstName() + \" \" +payment.getEmployee().getMiddleName()+\" \"+payment.getEmployee().getLastName())")
    @Mapping(target = "employeePhoneNumber",source = "payment.employee.phoneNumber")
    PaymentDto toDto (Payment payment);
    List<PaymentDto> toDtos (List<Payment> Payments);
}
