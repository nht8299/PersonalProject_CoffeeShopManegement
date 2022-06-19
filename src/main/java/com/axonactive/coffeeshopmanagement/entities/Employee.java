package com.axonactive.coffeeshopmanagement.entities;

import com.axonactive.coffeeshopmanagement.entities.enums.EmployeeRole;
import com.axonactive.coffeeshopmanagement.entities.enums.EmployeeType;
import com.axonactive.coffeeshopmanagement.entities.enums.Gender;
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
public class Employee {

    @Id
    private String id;

    @NotNull
    @Column(length = 30)
    private String lastName;

    @Column(length = 30)
    private String middleName;

    @NotNull
    @Column(length = 30)
    private String firstName;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    @Column(unique = true)
    private String phoneNumber;

    @NotNull
    private String address;

    @NotNull
    private String identity;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate startDate;

    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    private boolean status;

    @ManyToOne
    @JoinColumn
    private CoffeeShop coffeeShop;

    public boolean getStatus() {
        return this.status;
    }
}
