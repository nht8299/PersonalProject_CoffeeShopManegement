package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.entities.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    List<Invoice> getAll();

    Invoice createInvoice(Invoice invoice);

    Optional<Invoice> findInvoice(Integer id);

    void deleteInvoice (Integer id);

    Invoice update (Integer id,Invoice updateInvoice);
}
