package com.axonactive.coffeeshopmanagement.api.request;

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
    private Double costRatePerUnit;
    private Double price;
    private Integer unitInStock;
    private ItemStatus status;
    private String categoryName;
}
