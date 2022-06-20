package com.axonactive.coffeeshopmanagement.repositories;

import com.axonactive.coffeeshopmanagement.entities.Invoice;
import com.axonactive.coffeeshopmanagement.service.dto.DailyRevenueByInvoiceDto;
import com.axonactive.coffeeshopmanagement.service.dto.TotalRevenueOfPeriodTimeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {

    @Query(" FROM Invoice e " +
            "WHERE e.date BETWEEN :date1 and :date2 "+
            "ORDER by e.date ")
    List<Invoice> findByDateBetween(@Param("date1")LocalDate date1,@Param("date2")LocalDate date2);

    @Query("SELECT new com.axonactive.coffeeshopmanagement.service.dto.DailyRevenueByInvoiceDto" +
            "(i.date,COUNT(i.id),SUM(i.totalPrice)) " +
            "FROM Invoice i " +
            "WHERE i.date BETWEEN :date1 and :date2 "+
            "GROUP BY i.date")
    List<DailyRevenueByInvoiceDto> DailyRevenueBetweenTwoDate(@Param("date1")LocalDate date1,@Param("date2")LocalDate date2);

    @Query("SELECT new  com.axonactive.coffeeshopmanagement.service.dto.TotalRevenueOfPeriodTimeDto (Sum(i.totalPrice)) " +
            "FROM Invoice i " +
            "WHERE i.date BETWEEN :date1 and :date2 " )
    TotalRevenueOfPeriodTimeDto totalRevenueOfPeriodTime(@Param("date1")LocalDate date1, @Param("date2")LocalDate date2);


}
