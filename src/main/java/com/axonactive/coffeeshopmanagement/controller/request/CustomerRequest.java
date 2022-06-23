package com.axonactive.coffeeshopmanagement.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    @NotNull
    private String fullName;
    @NotNull
    private String phoneNumber;
    private String address;
    private String feedBack;
}
