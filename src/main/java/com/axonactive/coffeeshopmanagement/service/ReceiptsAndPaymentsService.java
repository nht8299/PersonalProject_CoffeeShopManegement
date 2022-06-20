package com.axonactive.coffeeshopmanagement.service;

import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.api.request.ReceiptsAndPaymentsRequest;
import com.axonactive.coffeeshopmanagement.entities.ReceiptsAndPayments;

import java.util.List;
import java.util.Optional;

public interface ReceiptsAndPaymentsService {

    List<ReceiptsAndPayments> getAll();

    ReceiptsAndPayments createReceiptsAndPayments(ReceiptsAndPaymentsRequest requestReceiptsAndPayments) throws ResourceNotFoundException;

    Optional<ReceiptsAndPayments> findById(Integer id);

    void deleteById(Integer id);

    ReceiptsAndPayments update (Integer id,ReceiptsAndPaymentsRequest receiptsAndPayments) throws ResourceNotFoundException;
}