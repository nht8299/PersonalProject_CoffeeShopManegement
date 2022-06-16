package com.axonactive.coffeeshopmanagement.Service.dto;

import com.axonactive.coffeeshopmanagement.entities.enums.ReceiptsOrPayments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptsAndPaymentsDto {

    private Integer id;
    private ReceiptsOrPayments type;
    private Double Amount;
    private String content;
    private String Description;
}
