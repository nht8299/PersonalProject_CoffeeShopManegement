package com.axonactive.coffeeshopmanagement.Service.implement;

import com.axonactive.coffeeshopmanagement.Service.PaymentService;
import com.axonactive.coffeeshopmanagement.entities.Payment;
import com.axonactive.coffeeshopmanagement.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository PaymentRepository;

    @Override
    public List<Payment> getAll() {
        return PaymentRepository.findAll();
    }

    @Override
    public Payment createPayment (Payment Payment) {
        return PaymentRepository.save(Payment);
    }

    @Override
    public Optional<Payment> findPayment(Integer id) {
        return PaymentRepository.findById(id);
    }

    @Override
    public void deletePayment(Integer id) {
        PaymentRepository.deleteById(id);
    }

    @Override
    public Payment update(Integer id, Payment updatePayment) {
        Payment Payment = new Payment();
        Payment.setEmployee(updatePayment.getEmployee());
        Payment.setSalary(updatePayment.getSalary());
        Payment.setRole(updatePayment.getRole());
        Payment.setDate(updatePayment.getDate());
        Payment.setBonus(updatePayment.getBonus());
        Payment.setEmployeeType(updatePayment.getEmployeeType());
        Payment.setWorkingHours(updatePayment.getWorkingHours());
        return PaymentRepository.save(Payment);
    }
}
