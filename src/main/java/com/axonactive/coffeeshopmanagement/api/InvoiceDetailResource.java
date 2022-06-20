package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.service.InvoiceDetailService;
import com.axonactive.coffeeshopmanagement.service.dto.InvoiceDetailDto;
import com.axonactive.coffeeshopmanagement.service.mapper.InvoiceDetailMapper;
import com.axonactive.coffeeshopmanagement.api.request.InvoiceDetailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "3600")
@RestController
@RequestMapping(InvoiceDetailResource.PATH)
public class InvoiceDetailResource {

    public static final String PATH = "/api/invoice_details";

    @Autowired
    InvoiceDetailService invoiceDetailService;

    @Autowired
    InvoiceDetailMapper invoiceDetailMapper;

    @GetMapping
    public ResponseEntity<List<InvoiceDetailDto>>findAll(){
        return ResponseEntity.ok(invoiceDetailMapper.toDtos(invoiceDetailService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDetailDto> findInvoiceDetailById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(invoiceDetailMapper.toDto(invoiceDetailService.findInvoiceDetail(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceDetailDto> update(@PathVariable(value = "id") Integer id, @RequestBody InvoiceDetailRequest requestInvoiceDetails) throws ResourceNotFoundException {
        return ResponseEntity.ok(invoiceDetailMapper.toDto(invoiceDetailService.update(id, requestInvoiceDetails)));
    }
}
