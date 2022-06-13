package com.axonactive.coffeeshopmanagement.api.request;

import com.axonactive.coffeeshopmanagement.entities.enums.EmployeeType;
import com.axonactive.coffeeshopmanagement.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private LocalDate date;
    private Role role;
    private EmployeeType employeeType;
    private Integer workingHours;
    private Double bonus;
    private Double Salary;
    private String EmployeePhoneNumber;
}
