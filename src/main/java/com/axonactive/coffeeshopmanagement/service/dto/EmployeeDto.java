package com.axonactive.coffeeshopmanagement.service.dto;

import com.axonactive.coffeeshopmanagement.entities.enums.EmployeeRole;
import com.axonactive.coffeeshopmanagement.entities.enums.EmployeeType;
import com.axonactive.coffeeshopmanagement.entities.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String id;
    private String fullName;
    private String dateOfBirth;
    private Gender gender;
    private String phoneNumber;
    private String address;
    private EmployeeRole role;
    private EmployeeType type;
    private String coffeeShopName;
}
