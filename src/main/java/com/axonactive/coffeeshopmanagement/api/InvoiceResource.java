//package com.axonactive.coffeeshopmanagement.api;
//
//import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
//import com.axonactive.coffeeshopmanagement.Service.InvoiceService;
//import com.axonactive.coffeeshopmanagement.Service.dto.InvoiceDto;
//import com.axonactive.coffeeshopmanagement.Service.mapper.InvoiceMapper;
//import com.axonactive.coffeeshopmanagement.api.request.InvoiceRequest;
//import com.axonactive.coffeeshopmanagement.entities.Invoice;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(InvoiceResource.PATH)
//public class InvoiceResource {
//
//    public static final String PATH = "/api/invoice";
//
//    @Autowired
//    InvoiceService invoiceService;
//
//    @Autowired
//    InvoiceMapper invoiceMapper;
//
//    @GetMapping
//    public ResponseEntity<List<InvoiceDto>> getAll(){
//        return ResponseEntity.ok(invoiceMapper.toDtos(invoiceService.getAll()));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<InvoiceDto> findInvoiceById(@PathVariable(value = "id")Integer id) throws NotFoundException {
//        return ResponseEntity.ok(invoiceMapper.toDto(invoiceService.findInvoice(id)
//                .orElseThrow(() -> new NotFoundException("Invoice not found: "+ id))));
//    }
//
//    @PostMapping
//    public ResponseEntity<Invoice> add(@RequestBody InvoiceRequest requestInvoice){
//        Invoice newInvoice = new Invoice();
//        newInvoice.set
//    }
//}
