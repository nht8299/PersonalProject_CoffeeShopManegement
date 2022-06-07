package com.axonactive.coffeeshopmanagement.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    @Id
    private String id;

    @NotNull
    private Integer quantity;

    private double discount;

    @JoinColumn
    @ManyToOne
    private Order order;

    @JoinColumn
    @ManyToOne
    private Item item;
}
