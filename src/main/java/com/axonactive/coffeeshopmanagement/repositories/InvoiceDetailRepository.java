package com.axonactive.coffeeshopmanagement.repositories;

import com.axonactive.coffeeshopmanagement.entities.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail,Integer> {

    List<InvoiceDetail> findByInvoiceId (Integer id);
}
