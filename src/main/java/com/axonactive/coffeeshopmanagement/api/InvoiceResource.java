package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.Service.InvoiceDetailService;
import com.axonactive.coffeeshopmanagement.Service.InvoiceService;
import com.axonactive.coffeeshopmanagement.Service.dto.InvoiceDetailDto;
import com.axonactive.coffeeshopmanagement.Service.dto.InvoiceDto;
import com.axonactive.coffeeshopmanagement.Service.mapper.InvoiceDetailMapper;
import com.axonactive.coffeeshopmanagement.Service.mapper.InvoiceMapper;
import com.axonactive.coffeeshopmanagement.api.request.InvoiceDetailRequest;
import com.axonactive.coffeeshopmanagement.api.request.InvoiceRequest;
import com.axonactive.coffeeshopmanagement.entities.Invoice;
import com.axonactive.coffeeshopmanagement.entities.InvoiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(value = "3600")
@RestController
@RequestMapping(InvoiceResource.PATH)
public class InvoiceResource {

    public static final String PATH = "/api/invoices";

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    InvoiceDetailService invoiceDetailService;

    @Autowired
    InvoiceMapper invoiceMapper;

    @Autowired
    InvoiceDetailMapper invoiceDetailMapper;

    @GetMapping
    public ResponseEntity<List<InvoiceDto>> getAll() {
        return ResponseEntity.ok(invoiceMapper.toDtos(invoiceService.getAll()));
    }

    @GetMapping("/{invoiceId}/invoice_details")
    public ResponseEntity<List<InvoiceDetailDto>> getAll(@PathVariable(value = "invoiceId") Integer invoiceId) throws ResourceNotFoundException {
        if (invoiceService.invoiceIsExist(invoiceId)) {
            return ResponseEntity.ok(invoiceDetailMapper.toDtos(invoiceDetailService.findByInvoiceId(invoiceId)));
        }
        throw new ResourceNotFoundException("Invoice not found with id: " + invoiceId);
    }

    @GetMapping("/{invoiceId}/invoice_details/{id}")
    public ResponseEntity<InvoiceDetailDto> getInvoiceDetailsById(@PathVariable(value = "invoiceId") Integer invoiceId, @PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        if (invoiceService.invoiceIsExist(invoiceId)) {
            return ResponseEntity.ok(invoiceDetailMapper.toDto(invoiceService.findInvoice(invoiceId).getInvoiceDetails().stream()
                    .filter(invoiceDetail -> invoiceDetail.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new ResourceNotFoundException("Invoice details not found with id: " + id))));
        }
        throw new ResourceNotFoundException("Invoice not found with id: " + invoiceId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDto> findInvoiceById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(invoiceMapper.toDto(invoiceService.findInvoice(id)));
    }

    @PostMapping
    public ResponseEntity<InvoiceDto> addInvoice(@RequestBody InvoiceRequest requestInvoice) throws ResourceNotFoundException {
        Invoice createInvoice = invoiceService.createInvoice(requestInvoice);
        return ResponseEntity
                .created(URI.create(EmployeeResource.PATH + "/" + createInvoice.getId()))
                .body(invoiceMapper.toDto(createInvoice));
    }

    @PostMapping("/{invoiceId}/invoice_details")
    public ResponseEntity<InvoiceDetailDto> addInvoiceDetails(@PathVariable(value = "invoiceId") Integer invoiceId, @RequestBody InvoiceDetailRequest requestInvoiceDetails) throws ResourceNotFoundException {
        if (invoiceService.invoiceIsExist(invoiceId)) {
            InvoiceDetail createInvoiceDetail = invoiceDetailService.createInvoiceDetail(invoiceId, requestInvoiceDetails);
            return ResponseEntity
                    .created(URI.create(InvoiceDetailResource.PATH + "/" + createInvoiceDetail.getId()))
                    .body(invoiceDetailMapper.toDto(createInvoiceDetail));
        } else throw new ResourceNotFoundException("Invoice not found with id: " + invoiceId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{invoiceId}/invoice_details/{id}")
    public ResponseEntity<Void> deleteInvoiceDetails(@PathVariable(value = "invoiceId")Integer invoiceId,@PathVariable(value = "id")Integer id) throws ResourceNotFoundException {
        if (invoiceService.invoiceIsExist(invoiceId)) {
          invoiceDetailService.deleteInvoiceDetails(id);
          return ResponseEntity.noContent().build();
        }else throw new ResourceNotFoundException("Invoice not found with id: " + invoiceId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceDto> update(@PathVariable(value = "id") Integer id, @RequestBody InvoiceRequest requestInvoice) throws ResourceNotFoundException {
        return ResponseEntity.ok(invoiceMapper.toDto(invoiceService.update(id, requestInvoice)));
    }

}
