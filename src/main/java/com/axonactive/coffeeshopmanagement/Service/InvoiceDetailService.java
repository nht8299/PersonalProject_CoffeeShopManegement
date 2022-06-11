package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.entities.InvoiceDetail;

import java.util.List;
import java.util.Optional;

public interface InvoiceDetailService {

    List<InvoiceDetail> getAll();

    InvoiceDetail createOrderDetail(InvoiceDetail orderDetail);

    Optional<InvoiceDetail> findOrderDetail(Integer id);

    void deleteOrderDetail(Integer id);
}
