package com.axonactive.coffeeshopmanagement.Service.implement;


import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.Service.*;
import com.axonactive.coffeeshopmanagement.api.request.InvoiceDetailRequest;
import com.axonactive.coffeeshopmanagement.api.request.InvoiceRequest;
import com.axonactive.coffeeshopmanagement.entities.Invoice;
import com.axonactive.coffeeshopmanagement.entities.InvoiceDetail;
import com.axonactive.coffeeshopmanagement.repositories.InvoiceDetailRepository;
import com.axonactive.coffeeshopmanagement.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;


    private final EmployeeService employeeService;

    private final CustomerService customerService;

    private final ItemService itemService;

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
        if (requestInvoice.getInvoiceDetailsRequest() != null) {
            List<InvoiceDetail> invoiceDetailList = new ArrayList<>();
            for (InvoiceDetailRequest invoiceDetailsRequest : requestInvoice.getInvoiceDetailsRequest()) {
                InvoiceDetail newInvoiceDetail = new InvoiceDetail();
                newInvoiceDetail.setItem(itemService.findItem(invoiceDetailsRequest.getItemId())
                        .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + invoiceDetailsRequest.getItemId())));
                newInvoiceDetail.setDiscount(invoiceDetailsRequest.getDiscount());
                newInvoiceDetail.setQuantity(invoiceDetailsRequest.getQuantity());
                newInvoiceDetail.setFinalPrice(newInvoiceDetail.getFinalPrice());
                newInvoiceDetail.setInvoice(newInvoice);
                invoiceDetailList.add(newInvoiceDetail);
            }
            newInvoice.setInvoiceDetailsList(invoiceDetailList);
            newInvoice.setPaymentMethod(requestInvoice.getPaymentMethod());
        }
        return invoiceRepository.saveAndFlush(newInvoice);
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
        Invoice updateInvoice = new Invoice();
        updateInvoice.setDate(LocalDate.now());
        updateInvoice.setTime(LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
        updateInvoice.setEmployee(employeeService.findEmployee(requestInvoice.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + requestInvoice.getEmployeeId())));
        updateInvoice.setCustomer(customerService.findByPhoneNumber(requestInvoice.getCustomerPhoneNumber())
                .orElseThrow(() -> new ResourceNotFoundException("customer not found: " + requestInvoice.getCustomerPhoneNumber())));
        if (requestInvoice.getInvoiceDetailsRequest() != null) {
            List<InvoiceDetail> invoiceDetailList = new ArrayList<>();
            for (InvoiceDetailRequest invoiceDetailsRequest : requestInvoice.getInvoiceDetailsRequest()) {
                InvoiceDetail newInvoiceDetail = new InvoiceDetail();
                newInvoiceDetail.setItem(itemService.findItem(invoiceDetailsRequest.getItemId())
                        .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + invoiceDetailsRequest.getItemId())));
                newInvoiceDetail.setDiscount(invoiceDetailsRequest.getDiscount());
                newInvoiceDetail.setQuantity(invoiceDetailsRequest.getQuantity());
                newInvoiceDetail.setFinalPrice(newInvoiceDetail.getFinalPrice());
                newInvoiceDetail.setInvoice(updateInvoice);
                invoiceDetailList.add(newInvoiceDetail);
            }
            updateInvoice.setInvoiceDetailsList(invoiceDetailList);
            updateInvoice.setPaymentMethod(requestInvoice.getPaymentMethod());
        }
        return invoiceRepository.saveAndFlush(updateInvoice);
    }

    public boolean invoiceIsExist(Integer id) {
        return invoiceRepository.existsById(id);
    }


}
