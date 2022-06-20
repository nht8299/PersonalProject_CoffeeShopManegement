package com.axonactive.coffeeshopmanagement.api.request;

import com.axonactive.coffeeshopmanagement.entities.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequest {

    private PaymentMethod paymentMethod;
    private String customerPhoneNumber;
    private String employeeId;
    private List<InvoiceDetailRequest> invoiceDetailsRequest;

}
