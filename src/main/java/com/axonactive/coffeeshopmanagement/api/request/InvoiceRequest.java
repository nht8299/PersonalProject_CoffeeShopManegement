package com.axonactive.coffeeshopmanagement.api.request;

import com.axonactive.coffeeshopmanagement.entities.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequest {

    private String id;
    private LocalDate date;
    private LocalTime time;
    private Double totalPrice;
    private PaymentMethod paymentMethod;
    private String customerPhoneNumber;
    private String employeeId;

}
