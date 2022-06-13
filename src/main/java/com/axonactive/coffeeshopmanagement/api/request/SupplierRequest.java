package com.axonactive.coffeeshopmanagement.api.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplierRequest {

    private String CompanyName;
    private String address;
    private String Location;
    private String phoneNumber;
    private String homePage;
}
