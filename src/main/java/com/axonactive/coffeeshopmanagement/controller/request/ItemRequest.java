package com.axonactive.coffeeshopmanagement.controller.request;

import com.axonactive.coffeeshopmanagement.entities.enums.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {

    private String id;
    private String name;
    private Integer price;
    private ItemStatus status;
    private Integer categoryId;
}
