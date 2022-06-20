package com.axonactive.coffeeshopmanagement.Service.implement;

import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.Service.EmployeeService;
import com.axonactive.coffeeshopmanagement.Service.ReceiptsAndPaymentsService;
import com.axonactive.coffeeshopmanagement.api.request.ReceiptsAndPaymentsRequest;
import com.axonactive.coffeeshopmanagement.entities.ReceiptsAndPayments;
import com.axonactive.coffeeshopmanagement.repositories.ReceiptsAndPaymentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReceiptsAndPaymentImpl implements ReceiptsAndPaymentsService {

    private final ReceiptsAndPaymentsRepository receiptsAndPaymentsRepository;

    private final EmployeeService employeeService;

    @Override
    public List<ReceiptsAndPayments> getAll() {
        return receiptsAndPaymentsRepository.findAll();
    }

    @Override
    public ReceiptsAndPayments createReceiptsAndPayments(ReceiptsAndPaymentsRequest requestReceiptsAndPayments) throws ResourceNotFoundException {
        ReceiptsAndPayments receiptsAndPayments = new ReceiptsAndPayments();
        receiptsAndPayments.setDate(LocalDate.now());
        receiptsAndPayments.setTime(LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
        receiptsAndPayments.setDescription(requestReceiptsAndPayments.getDescription());
        receiptsAndPayments.setContent(requestReceiptsAndPayments.getContent());
        receiptsAndPayments.setType(requestReceiptsAndPayments.getType());
        receiptsAndPayments.setAmount(requestReceiptsAndPayments.getAmount());
        receiptsAndPayments.setEmployee(employeeService.findEmployee(requestReceiptsAndPayments.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + requestReceiptsAndPayments.getEmployeeId())));
        return receiptsAndPaymentsRepository.save(receiptsAndPayments);
    }

    @Override
    public Optional<ReceiptsAndPayments> findById(Integer id) {
        return receiptsAndPaymentsRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        receiptsAndPaymentsRepository.deleteById(id);
    }

    @Override
    public ReceiptsAndPayments update(Integer id, ReceiptsAndPaymentsRequest requestReceiptsAndPayments) throws ResourceNotFoundException {
        ReceiptsAndPayments receiptsAndPayments = receiptsAndPaymentsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receipts or payments not found with id: " + id));
        receiptsAndPayments.setDate(LocalDate.now());
        receiptsAndPayments.setTime(LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
        receiptsAndPayments.setDescription(requestReceiptsAndPayments.getDescription());
        receiptsAndPayments.setContent(requestReceiptsAndPayments.getContent());
        receiptsAndPayments.setType(requestReceiptsAndPayments.getType());
        receiptsAndPayments.setAmount(requestReceiptsAndPayments.getAmount());
        receiptsAndPayments.setEmployee(employeeService.findEmployee(requestReceiptsAndPayments.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + requestReceiptsAndPayments.getEmployeeId())));
        return receiptsAndPaymentsRepository.save(receiptsAndPayments);
    }
}
