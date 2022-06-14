package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.entities.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    List<Payment> getAll();

    Payment createPayment(Payment Payment);

    Optional<Payment> findPayment(Integer id);

    void deletePayment(Integer id);

    Payment update(Integer id, Payment updatePayment);

}
