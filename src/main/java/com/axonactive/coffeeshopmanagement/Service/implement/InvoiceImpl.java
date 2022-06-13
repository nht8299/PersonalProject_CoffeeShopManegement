package com.axonactive.coffeeshopmanagement.Service.implement;


import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.InvoiceService;
import com.axonactive.coffeeshopmanagement.entities.Invoice;
import com.axonactive.coffeeshopmanagement.entities.InvoiceDetail;
import com.axonactive.coffeeshopmanagement.repositories.InvoiceDetailRepository;
import com.axonactive.coffeeshopmanagement.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private final InvoiceDetailRepository invoiceDetailRepository;

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

    @Override
    public Invoice update(Integer id, Invoice updateInvoice) {
        Invoice invoice = new Invoice();
        invoice.setPaymentMethod(updateInvoice.getPaymentMethod());
        invoice.setEmployee(updateInvoice.getEmployee());
        invoice.setCustomer(updateInvoice.getCustomer());
        invoice.setTime(updateInvoice.getTime());
        invoice.setDate(updateInvoice.getDate());
        invoice.setTotalPrice(invoiceDetailRepository.findByInvoiceId(id)
                .stream()
                .map(InvoiceDetail::getFinalPrice)
                        .reduce((double) 0,Double::sum)
                );
        return invoiceRepository.save(invoice);
    }
}
