package com.axonactive.coffeeshopmanagement.controller.request;

import com.axonactive.coffeeshopmanagement.entities.enums.ReceiptsOrPayments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptsAndPaymentsRequest {

    private ReceiptsOrPayments type;
    private Integer amount;
    private String content;
    private String description;
    private String EmployeeId;
}
