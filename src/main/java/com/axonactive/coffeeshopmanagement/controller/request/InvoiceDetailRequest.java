package com.axonactive.coffeeshopmanagement.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetailRequest {

    private String itemId;
    private Integer quantity;
    private Double discount;
}
