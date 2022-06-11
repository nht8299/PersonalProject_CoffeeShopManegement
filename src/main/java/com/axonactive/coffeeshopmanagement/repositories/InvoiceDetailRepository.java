package com.axonactive.coffeeshopmanagement.repositories;

import com.axonactive.coffeeshopmanagement.entities.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail,Integer> {
}
