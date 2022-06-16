package com.axonactive.coffeeshopmanagement.Service.mapper;

import com.axonactive.coffeeshopmanagement.Service.dto.ReceiptsAndPaymentsDto;
import com.axonactive.coffeeshopmanagement.entities.ReceiptsAndPayments;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReceiptsAndPaymentsMapper {

    ReceiptsAndPaymentsDto toDto (ReceiptsAndPayments receiptsAndPayments);
    List<ReceiptsAndPaymentsDto> toDtos (List<ReceiptsAndPayments> receiptsAndPaymentsList);
}
