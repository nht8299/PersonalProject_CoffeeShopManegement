package com.axonactive.coffeeshopmanagement.entities;

import com.axonactive.coffeeshopmanagement.entities.enums.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Item {

    @Id
    private String id;

    @NotNull
    @Column(length = 80)
    private String name;

    @NotNull
    private double costRatePerUnit;

    @NotNull
    private double price;

    @NotNull
    private int unitInStock;

    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    @JoinColumn
    @ManyToOne
    private Category category;
}
