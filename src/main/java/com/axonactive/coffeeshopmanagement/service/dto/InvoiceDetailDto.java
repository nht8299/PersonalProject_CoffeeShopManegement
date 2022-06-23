package com.axonactive.coffeeshopmanagement.service.dto;

import lombok.Data;

@Data
public class InvoiceDetailDto {

    private String invoiceId;
    private String itemName;
    private Integer itemPrice;
    private Integer finalPrice;
    private Integer quantity;
    private Double discount;

}
