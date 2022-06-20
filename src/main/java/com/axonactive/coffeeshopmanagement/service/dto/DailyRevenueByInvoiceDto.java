package com.axonactive.coffeeshopmanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyRevenueByInvoiceDto {
    private LocalDate date;
    private Long numberOfInvoice;
    private Double totalRevenue;
}
