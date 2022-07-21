package com.axonactive.coffeeshopmanagement.service.dto;

import com.axonactive.coffeeshopmanagement.entities.enums.EmployeeRole;
import com.axonactive.coffeeshopmanagement.entities.enums.EmployeeType;
import com.axonactive.coffeeshopmanagement.entities.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeFullDataDto {

    private String id;
    private String lastName;
    private String middleName;
    private String firstName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private Gender gender;
    private String address;
    private String identity;
    private LocalDate startDate;
    private EmployeeRole role;
    private EmployeeType type;
    private Boolean status;
    private Integer coffeeShopId;
}
