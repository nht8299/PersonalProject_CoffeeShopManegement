package com.axonactive.coffeeshopmanagement.controller.request;

import com.axonactive.coffeeshopmanagement.entities.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
