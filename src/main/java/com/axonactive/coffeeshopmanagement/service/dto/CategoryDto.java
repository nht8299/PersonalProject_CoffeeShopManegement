package com.axonactive.coffeeshopmanagement.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
    private Integer id;
    private String name;
    private String description;
}
