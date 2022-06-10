package com.axonactive.coffeeshopmanagement.Service.dto;

import com.axonactive.coffeeshopmanagement.entities.enums.PaymentMethod;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class InvoiceDto {

    private String id;
    private LocalDate date;
    private Double totalPrice;
    List<OrderDetailDto> orderDetailDtos;
    private PaymentMethod paymentMethod;
}
