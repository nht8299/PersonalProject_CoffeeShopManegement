package com.axonactive.coffeeshopmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeShop {

    @Id
    private String Name;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String address;

    @NotNull
    private String location;

    private String homepage;
}
