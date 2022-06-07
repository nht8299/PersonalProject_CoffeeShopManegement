package com.axonactive.coffeeshopmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {

    @Id
    private String id;

    @NotNull
    private LocalDate creationDate;

    @NotNull
    private LocalDate orderDate;

    private String orderDescription;

    @JoinColumn
    @ManyToOne
    private Customer customer;

    @JoinColumn
    @ManyToOne
    private Employee employee;
}
