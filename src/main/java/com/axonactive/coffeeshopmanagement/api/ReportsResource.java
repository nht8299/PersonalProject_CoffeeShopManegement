package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.api.request.DateRequest;
import com.axonactive.coffeeshopmanagement.service.InvoiceService;
import com.axonactive.coffeeshopmanagement.service.ItemService;
import com.axonactive.coffeeshopmanagement.service.dto.DailyRevenueByInvoiceDto;
import com.axonactive.coffeeshopmanagement.service.dto.InvoiceDto;
import com.axonactive.coffeeshopmanagement.service.dto.ItemSalesDetailsDto;
import com.axonactive.coffeeshopmanagement.service.dto.TotalRevenueOfPeriodTimeDto;
import com.axonactive.coffeeshopmanagement.service.mapper.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "3600")
@RestController
@RequestMapping(ReportsResource.PATH)
public class ReportsResource {

    public static final String PATH = "/api/reports";

    @Autowired
    ItemService itemService;

    @Autowired
    InvoiceMapper invoiceMapper;

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/get_invoice_by_date_between")
    public ResponseEntity<List<InvoiceDto>> findByDateBetween(@RequestBody DateRequest dateRequest) {
        return ResponseEntity.ok(invoiceMapper.toDtos(invoiceService.findByDateBetween(dateRequest.getDate1(),dateRequest.getDate2())));
    }

    @GetMapping("/get_daily_revenue_by_date_between")
    public ResponseEntity<List<DailyRevenueByInvoiceDto>> findDailyRevenueBetweenTwoDate(@RequestBody DateRequest dateRequest){
        return ResponseEntity.ok(invoiceService.DailyRevenueBetweenTwoDate(dateRequest.getDate1(),dateRequest.getDate2()));
    }

    @GetMapping("get_total_revenue_by_date_between")
    public ResponseEntity<TotalRevenueOfPeriodTimeDto> findTotalRevenueOfPeriodTime(@RequestBody DateRequest dateRequest){
        return ResponseEntity.ok(invoiceService.totalRevenueOfPeriodTime(dateRequest.getDate1(),dateRequest.getDate2()));
    }

    @GetMapping("get_number_of_item_sales_by_date_between")
    public ResponseEntity<List<ItemSalesDetailsDto>>findNumberOfItemSalesDetailsOfOnePeriod(@RequestBody DateRequest dateRequest){
        return ResponseEntity.ok(itemService.itemSalesDetailsOfOnePeriod(dateRequest.getDate1(),dateRequest.getDate2()));
    }

}
