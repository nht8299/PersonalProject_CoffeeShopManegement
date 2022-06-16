package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.InvoiceDetailService;
import com.axonactive.coffeeshopmanagement.Service.InvoiceService;
import com.axonactive.coffeeshopmanagement.Service.ItemService;
import com.axonactive.coffeeshopmanagement.Service.dto.InvoiceDetailDto;
import com.axonactive.coffeeshopmanagement.Service.mapper.InvoiceDetailMapper;
import com.axonactive.coffeeshopmanagement.api.request.InvoiceDetailRequest;
import com.axonactive.coffeeshopmanagement.entities.InvoiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(value = "3600")
@RestController
@RequestMapping(InvoiceDetailResource.PATH)
public class InvoiceDetailResource {

    public static final String PATH = "/api/invoicedetail";

    @Autowired
    InvoiceDetailService invoiceDetailService;

    @Autowired
    InvoiceDetailMapper invoiceDetailMapper;

    @Autowired
    ItemService itemService;

    @Autowired
    InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<InvoiceDetailDto>> getAll(){
        return ResponseEntity.ok(invoiceDetailMapper.toDtos(invoiceDetailService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDetailDto> findInvoiceDetailById(@PathVariable(value = "id")Integer id) throws NotFoundException {
        return ResponseEntity.ok(invoiceDetailMapper.toDto(invoiceDetailService.findInvoiceDetail(id)
                .orElseThrow(() -> new NotFoundException("Invoice detail not found: " + id))));
    }

    @PostMapping
    public ResponseEntity<InvoiceDetailDto> add(@RequestBody InvoiceDetailRequest requestInvoiceDetails) throws NotFoundException {
        InvoiceDetail newInvoiceDetail = new InvoiceDetail();
        newInvoiceDetail.setQuantity(requestInvoiceDetails.getQuantity());
        newInvoiceDetail.setDiscount(requestInvoiceDetails.getDiscount());
        newInvoiceDetail.setItem(itemService.findByNameContaining(requestInvoiceDetails.getItemName()));
        newInvoiceDetail.setInvoice(invoiceService.findInvoice(requestInvoiceDetails.getInvoiceId())
                .orElseThrow(() -> new NotFoundException("Invoice not found: "+ requestInvoiceDetails.getInvoiceId())));
        InvoiceDetail createInvoiceDetail = invoiceDetailService.createInvoiceDetail(newInvoiceDetail);
        return ResponseEntity
                .created(URI.create(InvoiceDetailResource.PATH +"/"+createInvoiceDetail.getId()))
                .body(invoiceDetailMapper.toDto(createInvoiceDetail));
    }

    @DeleteMapping("/id{}")
    public ResponseEntity<Void>delete(@PathVariable(value = "id")Integer id){
        invoiceDetailService.deleteOrderDetail(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceDetailDto> update(@PathVariable(value = "id")Integer id,@RequestBody InvoiceDetailRequest requestInvoiceDetails) throws NotFoundException {
        InvoiceDetail updateInvoiceDetail = new InvoiceDetail();
        updateInvoiceDetail.setQuantity(requestInvoiceDetails.getQuantity());
        updateInvoiceDetail.setDiscount(requestInvoiceDetails.getDiscount());
        updateInvoiceDetail.setItem(itemService.findByNameContaining(requestInvoiceDetails.getItemName()));
        updateInvoiceDetail.setInvoice(invoiceService.findInvoice(requestInvoiceDetails.getInvoiceId())
                .orElseThrow(() -> new NotFoundException("Invoice not found: "+ requestInvoiceDetails.getInvoiceId())));
        return ResponseEntity.ok(invoiceDetailMapper.toDto(invoiceDetailService.update(id,updateInvoiceDetail)));
    }
}
