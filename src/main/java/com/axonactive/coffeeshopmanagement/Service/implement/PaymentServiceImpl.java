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

    private final PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Optional<Payment> findPayment(Integer id) {
        return paymentRepository.findById(id);
    }

    @Override
    public void deletePayment(Integer id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public Payment update(Integer id, Payment updatePayment) {
        Payment payment = new Payment();
        payment.setEmployee(updatePayment.getEmployee());
        payment.setSalary(updatePayment.getSalary());
        payment.setRole(updatePayment.getRole());
        payment.setDate(updatePayment.getDate());
        payment.setBonus(updatePayment.getBonus());
        payment.setEmployeeType(updatePayment.getEmployeeType());
        payment.setWorkingHours(updatePayment.getWorkingHours());
        return paymentRepository.save(payment);
    }
}
