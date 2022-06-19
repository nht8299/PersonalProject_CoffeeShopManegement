package com.axonactive.coffeeshopmanagement.Service.implement;


import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.Service.CustomerService;
import com.axonactive.coffeeshopmanagement.Service.EmployeeService;
import com.axonactive.coffeeshopmanagement.Service.InvoiceService;
import com.axonactive.coffeeshopmanagement.api.request.InvoiceDetailRequest;
import com.axonactive.coffeeshopmanagement.api.request.InvoiceRequest;
import com.axonactive.coffeeshopmanagement.entities.Invoice;
import com.axonactive.coffeeshopmanagement.entities.InvoiceDetail;
import com.axonactive.coffeeshopmanagement.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private final EmployeeService employeeService;

    private final CustomerService customerService;

    @Override
    public List<Invoice> getAll() {
        List<Invoice> invoiceList = invoiceRepository.findAll();
        for (Invoice invoice : invoiceList
        ) {
            invoice.setTotalPrice(invoice.getTotalPrice());
            invoiceRepository.save(invoice);
        }
        return invoiceList;
    }


    @Override
    public Invoice createInvoice(InvoiceRequest requestInvoice) throws ResourceNotFoundException {
        Invoice newInvoice = new Invoice();
        newInvoice.setDate(LocalDate.now());
        newInvoice.setTime(LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
        newInvoice.setEmployee(employeeService.findEmployee(requestInvoice.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + requestInvoice.getEmployeeId())));
        newInvoice.setCustomer(customerService.findByPhoneNumber(requestInvoice.getCustomerPhoneNumber())
                .orElseThrow(() -> new ResourceNotFoundException("customer not found: " + requestInvoice.getCustomerPhoneNumber())));
        newInvoice.setPaymentMethod(requestInvoice.getPaymentMethod());
        return invoiceRepository.save(newInvoice);
    }

    @Override
    public Invoice findInvoice(Integer id) throws ResourceNotFoundException {
        Invoice findInvoice = invoiceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id: " + id));
        findInvoice.setTotalPrice(findInvoice.getTotalPrice());
        invoiceRepository.save(findInvoice);
        return findInvoice;
    }

    @Override
    public void deleteInvoice(Integer id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public Invoice update(Integer id, InvoiceRequest requestInvoice) throws ResourceNotFoundException {
        Invoice updateInvoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id: " + id));
        updateInvoice.setDate(LocalDate.now());
        updateInvoice.setTime(LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
        updateInvoice.setEmployee(employeeService.findEmployee(requestInvoice.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + requestInvoice.getEmployeeId())));
        updateInvoice.setCustomer(customerService.findByPhoneNumber(requestInvoice.getCustomerPhoneNumber())
                .orElseThrow(() -> new ResourceNotFoundException("customer not found: " + requestInvoice.getCustomerPhoneNumber())));
        updateInvoice.setPaymentMethod(requestInvoice.getPaymentMethod());
        updateInvoice.setTotalPrice(updateInvoice.getTotalPrice());
        return invoiceRepository.save(updateInvoice);
    }

    public boolean invoiceIsExist(Integer id) {
        return invoiceRepository.existsById(id);
    }


}
