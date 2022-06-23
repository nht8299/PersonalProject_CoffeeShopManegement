package com.axonactive.coffeeshopmanagement.service.dto;

import com.axonactive.coffeeshopmanagement.entities.enums.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private String id;
    private String name;
    private Integer price;
    private ItemStatus status;
    private String categoryName;
}
