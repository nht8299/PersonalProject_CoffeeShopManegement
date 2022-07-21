package com.axonactive.coffeeshopmanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Integer id;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String feedBack;
}
