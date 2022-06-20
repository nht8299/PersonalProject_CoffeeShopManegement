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
    private Integer customerId;
    private String employeeId;
    private Integer coffeeShopId;
    private List<InvoiceDetailRequest> invoiceDetailsRequest;

}
