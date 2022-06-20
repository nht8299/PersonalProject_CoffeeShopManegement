package com.axonactive.coffeeshopmanagement.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Access;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TotalRevenueOfPeriodTime {
    private Long TotalRevenue;
}
