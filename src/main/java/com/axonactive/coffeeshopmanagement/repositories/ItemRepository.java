package com.axonactive.coffeeshopmanagement.repositories;

import com.axonactive.coffeeshopmanagement.entities.Item;
import com.axonactive.coffeeshopmanagement.service.dto.ItemSalesDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item,String> {
    Item findByNameContaining(@Param(value = "name") String name);

    @Query("SELECT new com.axonactive.coffeeshopmanagement.service.dto.ItemSalesDetailsDto (d.item.id,e.name,SUM(d.quantity),SUM(i.totalPrice)) " +
            "FROM InvoiceDetail d, Item e, Invoice i " +
            "WHERE d.item.id = e.id AND d.invoice.id = i.id " +
            "AND i.date BETWEEN :date1 AND :date2 " +
            "GROUP BY e.name, d.item.id " +
            "ORDER BY SUM(d.quantity)")
    List<ItemSalesDetailsDto> itemSalesDetailsOfOnePeriod(@Param("date1") LocalDate date1, @Param("date2")LocalDate date2);
}
