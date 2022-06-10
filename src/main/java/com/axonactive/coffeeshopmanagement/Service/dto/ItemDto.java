package com.axonactive.coffeeshopmanagement.Service.dto;

import com.axonactive.coffeeshopmanagement.entities.enums.ItemStatus;

public class ItemDto {

    private String id;
    private String name;
    private Double costRatePerUnit;
    private Double price;
    private Integer unitInStock;
    private ItemStatus status;
    private String  categoryName;
}
