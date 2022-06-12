package com.axonactive.coffeeshopmanagement.Service.implement;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.InvoiceDetailService;
import com.axonactive.coffeeshopmanagement.entities.InvoiceDetail;
import com.axonactive.coffeeshopmanagement.repositories.InvoiceDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceDetailServiceImpl implements InvoiceDetailService {

    private final InvoiceDetailRepository invoiceDetailRepository;

    @Override
    public List<InvoiceDetail> getAll() {
        return invoiceDetailRepository.findAll();
    }

    @Override
    public InvoiceDetail createInvoiceDetail(InvoiceDetail orderDetail) {
        return invoiceDetailRepository.save(orderDetail);
    }

    @Override
    public Optional<InvoiceDetail> findInvoiceDetail(Integer id) {
        return invoiceDetailRepository.findById(id);
    }

    @Override
    public void deleteOrderDetail(Integer id) {
        invoiceDetailRepository.deleteById(id);
    }

    @Override
    public InvoiceDetail update(Integer id, InvoiceDetail updateInvoiceDetail) throws NotFoundException {
        InvoiceDetail invoiceDetail = invoiceDetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Invoice detail not found: "+ id));
        invoiceDetail.setQuantity(updateInvoiceDetail.getQuantity());
        invoiceDetail.setDiscount(updateInvoiceDetail.getDiscount());
        invoiceDetail.setInvoice(updateInvoiceDetail.getInvoice());
        invoiceDetail.setItem(updateInvoiceDetail.getItem());
        return invoiceDetailRepository.save(invoiceDetail);
    }
}
