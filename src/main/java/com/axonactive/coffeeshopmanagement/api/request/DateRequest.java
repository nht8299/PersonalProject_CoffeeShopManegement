package com.axonactive.coffeeshopmanagement.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateRequest {
    private LocalDate date1;
    private LocalDate date2;
}
