package com.axonactive.coffeeshopmanagement.entities;

import com.axonactive.coffeeshopmanagement.entities.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    @JoinColumn
    @ManyToOne
    private CoffeeShop coffeeShop;


    @OneToMany(mappedBy = "invoice",cascade = CascadeType.ALL,orphanRemoval = true)
    List<InvoiceDetail> invoiceDetailsList;


    public Double getTotalPrice() {
        double totalPrice = 0;
        if (null == this.invoiceDetailsList) {
            return totalPrice;
        }else {
            for (InvoiceDetail invoiceDetail : invoiceDetailsList) {
                totalPrice += invoiceDetail.getFinalPrice();
            }
           return totalPrice;
        }
    }

}
