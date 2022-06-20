package com.axonactive.coffeeshopmanagement.service.implement;

import com.axonactive.coffeeshopmanagement.service.InvoiceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class InvoiceServiceImplTest {

    @Autowired
    InvoiceService invoiceService;

    @Test
    void testFindByDateBetween_shouldReturnListInvoice_whenFound() {
        assertEquals(10,invoiceService.findByDateBetween(LocalDate.parse("2022-06-01"),LocalDate.parse("2022-06-10")).size());
    }

    @Test
    void testFindDailyRevenueBetweenTwoDate_shouldReturnListDailyRevenue_whenFound(){
        assertEquals(10,invoiceService.DailyRevenueBetweenTwoDate(LocalDate.parse("2022-06-01"),LocalDate.parse("2022-06-10")).size());
    }
    @Test
    void testGetTotalRevenueOfPeriodOfTime_shouldReturnSumTotalPrice_whenFound(){
        assertEquals(1672700,invoiceService.totalRevenueOfPeriodTime(LocalDate.parse("2022-06-01"),LocalDate.parse("2022-06-10")).getTotalRevenue());
    }

}