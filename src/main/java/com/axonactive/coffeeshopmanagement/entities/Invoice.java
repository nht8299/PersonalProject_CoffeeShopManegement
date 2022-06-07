package com.axonactive.coffeeshopmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    private String id;

    @NotNull
    private double totalPrice;

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalTime time;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
}
