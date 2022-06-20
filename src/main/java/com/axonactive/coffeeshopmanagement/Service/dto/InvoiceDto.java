package com.axonactive.coffeeshopmanagement.service.dto;

import com.axonactive.coffeeshopmanagement.entities.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceDto {

    private String id;
    private LocalDate date;
    private LocalTime time;
    private Double totalPrice;
    private PaymentMethod paymentMethod;
    private String customerName;
    private String customerPhoneNumber;
    private String employeeFullName;
    private List<InvoiceDetailDto> invoiceDetailsList;
}
