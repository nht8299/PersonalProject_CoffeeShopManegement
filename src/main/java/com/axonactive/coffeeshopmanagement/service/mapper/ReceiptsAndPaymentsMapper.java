package com.axonactive.coffeeshopmanagement.service.mapper;

import com.axonactive.coffeeshopmanagement.service.dto.ReceiptsAndPaymentsDto;
import com.axonactive.coffeeshopmanagement.entities.ReceiptsAndPayments;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReceiptsAndPaymentsMapper {

    @Mapping(target = "employeeName",expression = "java(receiptsAndPayments.getEmployee().getFirstName() + \" \" +receiptsAndPayments.getEmployee().getMiddleName()+\" \"+receiptsAndPayments.getEmployee().getLastName())")
    ReceiptsAndPaymentsDto toDto (ReceiptsAndPayments receiptsAndPayments);
    List<ReceiptsAndPaymentsDto> toDtos (List<ReceiptsAndPayments> receiptsAndPaymentsList);
}
