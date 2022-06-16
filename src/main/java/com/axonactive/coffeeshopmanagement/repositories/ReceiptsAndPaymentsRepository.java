package com.axonactive.coffeeshopmanagement.repositories;

import com.axonactive.coffeeshopmanagement.entities.ReceiptsAndPayments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptsAndPaymentsRepository extends JpaRepository<ReceiptsAndPayments,Integer> {
}
