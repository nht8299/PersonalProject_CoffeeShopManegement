package com.axonactive.coffeeshopmanagement.entities;

import com.axonactive.coffeeshopmanagement.entities.enums.EmployeeType;
import com.axonactive.coffeeshopmanagement.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private LocalDate date;

    @NotNull
    private Role role;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @NotNull
    private Integer workingHours;

    private Double bonus;

    @NotNull
    private Double Salary;

    @JoinColumn
    @ManyToOne
    private Employee employee;
}
