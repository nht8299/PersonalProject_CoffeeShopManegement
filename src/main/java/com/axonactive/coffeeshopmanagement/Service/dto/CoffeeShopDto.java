package com.axonactive.coffeeshopmanagement.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeShopDto {

    private String name;
    private String phoneNumber;
    private String address;
    private String location;
    private String homepage;
}
