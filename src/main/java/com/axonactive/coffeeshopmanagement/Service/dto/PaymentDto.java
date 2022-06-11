package com.axonactive.coffeeshopmanagement.Service.dto;

import com.axonactive.coffeeshopmanagement.entities.enums.EmployeeType;
import com.axonactive.coffeeshopmanagement.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private String id;
    private LocalDate date;
    private EmployeeType employeeType;
    private Role role;
    private Integer workingHours;
    private Double bonus;
    private Double salary;
    private String employeeId;
    private String employeeFullName;
    private String employeePhoneNumber;
}
