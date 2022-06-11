package com.axonactive.coffeeshopmanagement.entities;

import com.axonactive.coffeeshopmanagement.entities.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Double totalPrice;

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalTime time;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @JoinColumn
    @ManyToOne
    private Customer customer;

    @JoinColumn
    @ManyToOne
    private Employee employee;


}
