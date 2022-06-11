package com.axonactive.coffeeshopmanagement.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    private String fullName;
    private String phoneNumber;
    private String address;
    private String feedBack;
}
