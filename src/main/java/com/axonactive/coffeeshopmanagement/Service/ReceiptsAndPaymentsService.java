package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.dto.ReceiptsAndPaymentsDto;
import com.axonactive.coffeeshopmanagement.entities.ReceiptsAndPayments;

import java.util.List;
import java.util.Optional;

public interface ReceiptsAndPaymentsService {

    List<ReceiptsAndPayments> getAll();

    ReceiptsAndPayments create(ReceiptsAndPayments receiptsAndPayments);

    Optional<ReceiptsAndPayments> findById(Integer id);

    void deleteById(Integer id);

    ReceiptsAndPayments update (Integer id,ReceiptsAndPayments receiptsAndPayments) throws NotFoundException;
}
