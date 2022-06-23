package com.axonactive.coffeeshopmanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemSalesDetailsDto {

    private String itemId;
    private String itemName;
    private Long salesNumber;
    private Long totalPrice;
}
