package com.axonactive.coffeeshopmanagement.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeShopRequest {

    private String name;
    private String phoneNumber;
    private String location;
    private String address;
    private String homepage;
}
