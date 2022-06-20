package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.api.request.InvoiceDetailRequest;
import com.axonactive.coffeeshopmanagement.entities.InvoiceDetail;

import java.util.List;

public interface InvoiceDetailService {

    List<InvoiceDetail> getAll();

    InvoiceDetail createInvoiceDetail(Integer invoiceId, InvoiceDetailRequest requestInvoiceDetail) throws ResourceNotFoundException;

    InvoiceDetail findInvoiceDetail(Integer id) throws ResourceNotFoundException;

    void deleteInvoiceDetails(Integer id) throws ResourceNotFoundException;

    void deleteByInvoiceId(Integer id);

    InvoiceDetail update(Integer id, InvoiceDetailRequest RequestInvoiceDetail) throws ResourceNotFoundException;

    List<InvoiceDetail> findByInvoiceId(Integer id) throws ResourceNotFoundException;
}
