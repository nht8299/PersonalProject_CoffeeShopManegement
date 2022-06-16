package com.axonactive.coffeeshopmanagement.Service.implement;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.ReceiptsAndPaymentsService;
import com.axonactive.coffeeshopmanagement.entities.ReceiptsAndPayments;
import com.axonactive.coffeeshopmanagement.repositories.ReceiptsAndPaymentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReceiptsAndPaymentImpl implements ReceiptsAndPaymentsService {

    private final ReceiptsAndPaymentsRepository receiptsAndPaymentsRepository;


    @Override
    public List<ReceiptsAndPayments> getAll() {
        return receiptsAndPaymentsRepository.findAll();
    }

    @Override
    public ReceiptsAndPayments create(ReceiptsAndPayments receiptsAndPayments) {
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
    public ReceiptsAndPayments update(Integer id, ReceiptsAndPayments updateReceiptsAndPayments) throws NotFoundException {
        ReceiptsAndPayments receiptsAndPayments = receiptsAndPaymentsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Receipts or payments not found with id: "+id));
        receiptsAndPayments.setAmount(updateReceiptsAndPayments.getAmount());
        receiptsAndPayments.setContent(updateReceiptsAndPayments.getContent());
        receiptsAndPayments.setType(updateReceiptsAndPayments.getType());
        receiptsAndPayments.setDescription(updateReceiptsAndPayments.getDescription());
        return receiptsAndPaymentsRepository.save(receiptsAndPayments);
    }
}
