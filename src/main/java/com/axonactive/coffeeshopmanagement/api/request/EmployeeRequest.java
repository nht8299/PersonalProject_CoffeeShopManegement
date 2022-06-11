package com.axonactive.coffeeshopmanagement.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    private String lastName;
    private String middleName;
    private String firstName;
    private LocalDate dateOfBirth;
    private String PhoneNumber;
    private String address;
    private String identity;
    private LocalDate startDate;
    private String coffeeShopName;
}
