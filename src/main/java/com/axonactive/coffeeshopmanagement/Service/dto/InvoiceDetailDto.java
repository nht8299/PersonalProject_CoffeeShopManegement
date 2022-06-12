package com.axonactive.coffeeshopmanagement.Service.dto;

import lombok.Data;

@Data
public class InvoiceDetailDto {

    private String invoiceId;
    private String itemName;
    private Double itemPrice;
    private Integer quantity;
    private Double discount;

}
