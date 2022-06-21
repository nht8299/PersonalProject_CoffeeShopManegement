package com.axonactive.coffeeshopmanagement.service.implement;

import com.axonactive.coffeeshopmanagement.exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.service.InvoiceDetailService;
import com.axonactive.coffeeshopmanagement.service.ItemService;
import com.axonactive.coffeeshopmanagement.api.request.InvoiceDetailRequest;
import com.axonactive.coffeeshopmanagement.entities.InvoiceDetail;
import com.axonactive.coffeeshopmanagement.repositories.InvoiceDetailRepository;
import com.axonactive.coffeeshopmanagement.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceDetailServiceImpl implements InvoiceDetailService {

    private final InvoiceDetailRepository invoiceDetailRepository;

    private final ItemService itemService;

    private final InvoiceRepository invoiceRepository;

    @Override
    public List<InvoiceDetail> getAll() {
        return invoiceDetailRepository.findAll();
    }

    @Override
    public InvoiceDetail createInvoiceDetail(Integer invoiceId, InvoiceDetailRequest requestInvoiceDetails) throws ResourceNotFoundException {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        invoiceDetail.setItem(itemService.findItem(requestInvoiceDetails.getItemId()).orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + requestInvoiceDetails.getItemId())));
        invoiceDetail.setQuantity(requestInvoiceDetails.getQuantity());
        invoiceDetail.setDiscount(requestInvoiceDetails.getDiscount());
        invoiceDetail.setFinalPrice(invoiceDetail.getFinalPrice());
        invoiceDetail.setInvoice(invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id: " + invoiceId)));
        return invoiceDetailRepository.save(invoiceDetail);
    }


    @Override
    public InvoiceDetail findInvoiceDetail(Integer id) throws ResourceNotFoundException {
        return invoiceDetailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice details not found with id: " + id));
    }

    @Override
    public void deleteInvoiceDetails(Integer id) {
        invoiceDetailRepository.deleteById(id);
    }

    @Override
    public InvoiceDetail update(Integer id, InvoiceDetailRequest requestInvoiceDetails) throws ResourceNotFoundException {
        InvoiceDetail invoiceDetail = invoiceDetailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice detail not found: " + id));
        invoiceDetail.setQuantity(requestInvoiceDetails.getQuantity());
        invoiceDetail.setDiscount(requestInvoiceDetails.getDiscount());
        invoiceDetail.setItem(itemService.findItem(requestInvoiceDetails.getItemId())
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id)));
        invoiceDetail.getFinalPrice();
        return invoiceDetailRepository.save(invoiceDetail);
    }

    @Override
    public List<InvoiceDetail> findByInvoiceId(Integer id) throws ResourceNotFoundException {
//        List<InvoiceDetail> invoiceDetailsList = new ArrayList<>();
//        for (InvoiceDetail invoiceDetails : invoiceDetailRepository.findByInvoiceId(id)) {
//            invoiceDetails.getFinalPrice();
//        }
//        invoiceRepository.save(invoiceRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id: " + id)));
        return invoiceDetailRepository.findByInvoiceId(id);
    }

    @Override
    public void deleteByInvoiceId(Integer id) {
        invoiceDetailRepository.deleteByInvoiceId(id);
    }
}
