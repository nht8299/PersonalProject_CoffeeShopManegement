package com.axonactive.coffeeshopmanagement.Service.dto;

import com.axonactive.coffeeshopmanagement.entities.enums.ReceiptsOrPayments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptsAndPaymentsDto {

    private Integer id;
    private LocalDate date;
    private LocalTime time;
    private ReceiptsOrPayments type;
    private Double amount;
    private String content;
    private String description;
    private String employeeName;
}
