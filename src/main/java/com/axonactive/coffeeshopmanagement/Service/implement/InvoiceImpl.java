package com.axonactive.coffeeshopmanagement.Service.implement;


import com.axonactive.coffeeshopmanagement.Service.InvoiceService;
import com.axonactive.coffeeshopmanagement.entities.Invoice;
import com.axonactive.coffeeshopmanagement.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public com.axonactive.coffeeshopmanagement.entities.Invoice createInvoice(com.axonactive.coffeeshopmanagement.entities.Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Optional<com.axonactive.coffeeshopmanagement.entities.Invoice> findInvoice(Integer id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public void deleteInvoice(Integer id) {
        invoiceRepository.deleteById(id);
    }
}
