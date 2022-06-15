package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.CustomerService;
import com.axonactive.coffeeshopmanagement.Service.EmployeeService;
import com.axonactive.coffeeshopmanagement.Service.InvoiceService;
import com.axonactive.coffeeshopmanagement.Service.dto.InvoiceDto;
import com.axonactive.coffeeshopmanagement.Service.mapper.InvoiceMapper;
import com.axonactive.coffeeshopmanagement.api.request.InvoiceRequest;
import com.axonactive.coffeeshopmanagement.entities.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(InvoiceResource.PATH)
public class InvoiceResource {

    public static final String PATH = "/api/invoice";

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    InvoiceMapper invoiceMapper;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<InvoiceDto>> getAll(){
        return ResponseEntity.ok(invoiceMapper.toDtos(invoiceService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDto> findInvoiceById(@PathVariable(value = "id")Integer id) throws NotFoundException {
        return ResponseEntity.ok(invoiceMapper.toDto(invoiceService.findInvoice(id)
                .orElseThrow(() -> new NotFoundException("Invoice not found: "+ id))));
    }

    @PostMapping
    public ResponseEntity<InvoiceDto> add(@RequestBody InvoiceRequest requestInvoice) throws NotFoundException {
        Invoice newInvoice = new Invoice();
        newInvoice.setDate(LocalDate.now());
        newInvoice.setTime(LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
        newInvoice.setEmployee(employeeService.findEmployee(requestInvoice.getEmployeeId())
                .orElseThrow(() -> new NotFoundException("Employee not found: "+ requestInvoice.getEmployeeId()) ));
        newInvoice.setCustomer(customerService.findByPhoneNumber(requestInvoice.getCustomerPhoneNumber())
                .orElseThrow(() -> new NotFoundException("customer not found: "+ requestInvoice.getCustomerPhoneNumber())));
        newInvoice.setPaymentMethod(requestInvoice.getPaymentMethod());
        Invoice createInvoice = invoiceService.createInvoice(newInvoice);
        return ResponseEntity
                .created(URI.create(EmployeeResource.PATH+"/"+createInvoice.getId()))
                .body(invoiceMapper.toDto(createInvoice));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id")Integer id){
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<InvoiceDto> update(@PathVariable(value = "id")Integer id,@RequestBody InvoiceRequest requestInvoice) throws NotFoundException {
        Invoice updateInvoice = invoiceService.findInvoice(id).orElseThrow(() -> new NotFoundException("Invoice not found: "+id));
        updateInvoice.setDate(LocalDate.now());
        updateInvoice.setTime(LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
        updateInvoice.setEmployee(employeeService.findEmployee(requestInvoice.getEmployeeId())
                .orElseThrow(() -> new NotFoundException("Employee not found: "+ requestInvoice.getEmployeeId()) ));
        updateInvoice.setCustomer(customerService.findByPhoneNumber(requestInvoice.getCustomerPhoneNumber())
                .orElseThrow(() -> new NotFoundException("customer not found: "+ requestInvoice.getCustomerPhoneNumber())));
        updateInvoice.setPaymentMethod(requestInvoice.getPaymentMethod());
        return ResponseEntity.ok(invoiceMapper.toDto(invoiceService.update(id,updateInvoice)));
    }
}
