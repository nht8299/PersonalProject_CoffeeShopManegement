package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.entities.InvoiceDetail;

import java.util.List;
import java.util.Optional;

public interface InvoiceDetailService {

    List<InvoiceDetail> getAll();

    InvoiceDetail createInvoiceDetail(InvoiceDetail orderDetail);

    Optional<InvoiceDetail> findInvoiceDetail(Integer id);

    void deleteOrderDetail(Integer id);

    InvoiceDetail update(Integer id, InvoiceDetail updateInvoiceDetail) throws NotFoundException;
}
