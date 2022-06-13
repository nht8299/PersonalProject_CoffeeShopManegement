package com.axonactive.coffeeshopmanagement.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDto {
    private Integer id;
    private String CompanyName;
    private String address;
    private String Location;
    private String phoneNumber;
    private String homePage;
}
