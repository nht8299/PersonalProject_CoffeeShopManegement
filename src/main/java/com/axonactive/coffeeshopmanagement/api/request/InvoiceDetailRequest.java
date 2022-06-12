package com.axonactive.coffeeshopmanagement.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetailRequest {

    private Integer invoiceId;
    private String itemName;
    private Integer quantity;
    private Double discount;
}
