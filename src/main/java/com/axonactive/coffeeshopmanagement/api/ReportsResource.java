package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.api.request.DateRequest;
import com.axonactive.coffeeshopmanagement.service.InvoiceService;
import com.axonactive.coffeeshopmanagement.service.dto.InvoiceDto;
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
    InvoiceMapper invoiceMapper;

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/find_invoice_by_date_between")
    public ResponseEntity<List<InvoiceDto>> findByDateBetween(@RequestBody DateRequest dateRequest) {
        return ResponseEntity.ok(invoiceMapper.toDtos(invoiceService.findByDateBetween(dateRequest.getDate1(),dateRequest.getDate2())));
    }
}
