package com.axonactive.coffeeshopmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Supplier {

    @Id
    private String id;

    @NotNull
    @Column(length = 100)
    private String companyName;

    @NotNull
    @Column(length = 100)
    private String address;

    @NotNull
    private String Location;

    @NotNull
    private String phoneNumber;

    private String homePage;
}
