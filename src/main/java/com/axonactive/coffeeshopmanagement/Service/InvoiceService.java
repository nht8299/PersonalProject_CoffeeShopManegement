package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.api.request.InvoiceDetailRequest;
import com.axonactive.coffeeshopmanagement.api.request.InvoiceRequest;
import com.axonactive.coffeeshopmanagement.entities.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    List<Invoice> getAll();

    Invoice createInvoice(InvoiceRequest requestInvoice) throws ResourceNotFoundException;

    Invoice findInvoice(Integer id) throws ResourceNotFoundException;

    void deleteInvoice(Integer id);

    Invoice update(Integer id, InvoiceRequest requestInvoice) throws ResourceNotFoundException;

    boolean invoiceIsExist(Integer id);
}


