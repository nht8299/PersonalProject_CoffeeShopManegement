package com.axonactive.coffeeshopmanagement.Service.dto;

import lombok.Data;

@Data
public class OrderDetailDto {

    private String itemName;
    private Double price;
    private Integer quantity;
    private Double discount;

}
