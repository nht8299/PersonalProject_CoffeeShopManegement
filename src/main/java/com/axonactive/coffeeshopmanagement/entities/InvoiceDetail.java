package com.axonactive.coffeeshopmanagement.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static org.hibernate.annotations.OnDeleteAction.CASCADE;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer quantity;

    private Double discount;

    private Integer finalPrice;

    @JoinColumn(name = "invoice_id", nullable = false)
    @OnDelete(action = CASCADE)
    @ManyToOne
    @JsonIgnore
    private Invoice invoice;

    @JoinColumn(name = "item_id", nullable = false)
    @ManyToOne
    private Item item;

    public Integer getFinalPrice() {
        int finalPrice;
        if (this.discount != 0) {
            finalPrice =(this.item.getPrice() * this.quantity)-((int)(this.item.getPrice()*this.quantity*this.discount));
        } else {
            finalPrice = this.item.getPrice() * this.quantity;
        }
        return finalPrice;
    }


}
