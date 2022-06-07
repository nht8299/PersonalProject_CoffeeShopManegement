package com.axonactive.coffeeshopmanagement.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private String id;

    @NotNull
    @Column(length = 80)
    private String fullName;

    @Column(length = 80)
    private String address;

    @NotNull
    private String phoneNumber;

    private String feedBack;
}
