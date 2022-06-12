package com.axonactive.coffeeshopmanagement.api.request;

import com.axonactive.coffeeshopmanagement.entities.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    private String id;
    private String lastName;
    private String middleName;
    private String firstName;
    private LocalDate dateOfBirth;
    private String PhoneNumber;
    private Gender gender;
    private String address;
    private String identity;
    private LocalDate startDate;
    private String coffeeShopName;
}
