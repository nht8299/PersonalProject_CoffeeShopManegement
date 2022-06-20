package com.axonactive.coffeeshopmanagement.service.implement;

import com.axonactive.coffeeshopmanagement.service.ItemService;
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
class ItemServiceImplTest {

    @Autowired
    ItemService itemService;

    @Test
    void getItemSalesDetailsOfOnePeriod_shouldReturnListOfItemSales_whenFound() {
        assertEquals(18,itemService.itemSalesDetailsOfOnePeriod(LocalDate.parse("2022-06-01"),LocalDate.parse("2022-06-10")).size());
    }
}