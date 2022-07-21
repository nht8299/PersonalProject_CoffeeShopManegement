package com.axonactive.coffeeshopmanagement.service.implement;


import com.axonactive.coffeeshopmanagement.exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.service.*;
import com.axonactive.coffeeshopmanagement.service.dto.DailyRevenueByInvoiceDto;
import com.axonactive.coffeeshopmanagement.service.dto.TotalRevenueOfPeriodTimeDto;
import com.axonactive.coffeeshopmanagement.controller.request.InvoiceDetailRequest;
import com.axonactive.coffeeshopmanagement.controller.request.InvoiceRequest;
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

    private final InvoiceDetailRepository invoiceDetailRepository;

    private final InvoiceRepository invoiceRepository;


    private final EmployeeService employeeService;

    private final CustomerService customerService;

    private final ItemService itemService;

    private final CoffeeShopService coffeeShopService;

    @Override
    public List<Invoice> getAll() {
        List<Invoice> invoiceList = invoiceRepository.findAll();
        for (Invoice invoice : invoiceList
        ) {
            invoice.getInvoiceDetailsList().forEach(invoiceDetail -> {
                invoiceDetail.setFinalPrice(invoiceDetail.getFinalPrice());
                invoiceDetailRepository.save(invoiceDetail);
            });
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
        if (employeeService.findEmployee(requestInvoice.getEmployeeId()).get().getCoffeeShop().equals(coffeeShopService.findCoffeeShop(requestInvoice.getCoffeeShopId()).get())) {
            newInvoice.setEmployee(employeeService.findEmployee(requestInvoice.getEmployeeId())
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found haha: " + requestInvoice.getEmployeeId())));
            newInvoice.setCoffeeShop(coffeeShopService.findCoffeeShop(requestInvoice.getCoffeeShopId())
                    .orElseThrow(() -> new ResourceNotFoundException("CoffeeShop not found with id: " + requestInvoice.getCoffeeShopId())));
        } else throw new ResourceNotFoundException("Business exception!");
        newInvoice.setCustomer(customerService.findCustomer(requestInvoice.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("customer not found: " + requestInvoice.getCustomerId())));
        if (requestInvoice.getInvoiceDetailsRequest() != null) {
            List<InvoiceDetail> invoiceDetailList = new ArrayList<>();
            for (InvoiceDetailRequest invoiceDetailsRequest : requestInvoice.getInvoiceDetailsRequest()) {
                InvoiceDetail newInvoiceDetail = new InvoiceDetail();
                newInvoiceDetail.setItem(itemService.findItem(invoiceDetailsRequest.getItemId())
                        .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + invoiceDetailsRequest.getItemId())));
                if ( null == newInvoiceDetail.getDiscount() ){
                    newInvoiceDetail.setDiscount(0.0);
                }else {
                    newInvoiceDetail.setDiscount(invoiceDetailsRequest.getDiscount());
                }
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
        findInvoice.getInvoiceDetailsList().forEach(invoiceDetail -> {
            invoiceDetail.setFinalPrice(invoiceDetail.getFinalPrice());
            invoiceDetailRepository.save(invoiceDetail);
        });
        invoiceRepository.save(findInvoice);
        return findInvoice;
    }

    @Override
    public void deleteInvoice(Integer id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public Invoice update(Integer id, InvoiceRequest requestInvoice) throws ResourceNotFoundException {
        if ( employeeService.findEmployee(requestInvoice.getEmployeeId()).isPresent() ) {
            Invoice updateInvoice = invoiceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + requestInvoice.getEmployeeId()));

            updateInvoice.setDate(LocalDate.now());
            updateInvoice.setTime(LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));

            if ( employeeService.findEmployee(requestInvoice.getEmployeeId()).get().getCoffeeShop()
                    .equals(coffeeShopService.findCoffeeShop(requestInvoice.getCoffeeShopId()).get()) ) {
                updateInvoice.setEmployee(employeeService.findEmployee(requestInvoice.getEmployeeId())
                        .orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + requestInvoice.getEmployeeId())));
                updateInvoice.setCoffeeShop(coffeeShopService.findCoffeeShop(requestInvoice.getCoffeeShopId())
                        .orElseThrow(() -> new ResourceNotFoundException("CoffeeShop not found with id: " + requestInvoice.getCoffeeShopId())));
            } else throw new ResourceNotFoundException("Business exception!");
            updateInvoice.setCustomer(customerService.findCustomer(requestInvoice.getCustomerId())
                    .orElseThrow(() -> new ResourceNotFoundException("customer not found: " + requestInvoice.getCustomerId())));
            if ( requestInvoice.getInvoiceDetailsRequest() != null ) {
                List<InvoiceDetail> invoiceDetailList = new ArrayList<>();
                for (InvoiceDetailRequest invoiceDetailsRequest : requestInvoice.getInvoiceDetailsRequest()) {
                    InvoiceDetail newInvoiceDetail = new InvoiceDetail();
                    newInvoiceDetail.setItem(itemService.findItem(invoiceDetailsRequest.getItemId())
                            .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + invoiceDetailsRequest.getItemId())));
                    if ( null == newInvoiceDetail.getDiscount() ) {
                        newInvoiceDetail.setDiscount(0.0);
                    } else {
                        newInvoiceDetail.setDiscount(invoiceDetailsRequest.getDiscount());
                    }
                    newInvoiceDetail.setQuantity(invoiceDetailsRequest.getQuantity());
                    newInvoiceDetail.setFinalPrice(newInvoiceDetail.getFinalPrice());
                    newInvoiceDetail.setInvoice(updateInvoice);
                    invoiceDetailList.add(newInvoiceDetail);
                }
                updateInvoice.setInvoiceDetailsList(invoiceDetailList);
                updateInvoice.setPaymentMethod(requestInvoice.getPaymentMethod());

        }
        return invoiceRepository.saveAndFlush(updateInvoice);
        }else throw new ResourceNotFoundException("Invoice not found with id"+id);
    }
    public boolean invoiceIsExist(Integer id) {
        return invoiceRepository.existsById(id);
    }

    @Override
    public List<Invoice> findByDateBetween(LocalDate date1, LocalDate date2) {
        return invoiceRepository.findByDateBetween(date1,date2);
    }

    @Override
    public List<DailyRevenueByInvoiceDto> DailyRevenueBetweenTwoDate(LocalDate date1, LocalDate date2) {
        return invoiceRepository.DailyRevenueBetweenTwoDate(date1,date2);
    }

    @Override
    public TotalRevenueOfPeriodTimeDto totalRevenueOfPeriodTime(LocalDate date1,LocalDate date2){
        return invoiceRepository.totalRevenueOfPeriodTime(date1,date2);
    }

    @Override
    public List<Invoice> findInvoiceByCustomerId(Integer id){
        return invoiceRepository.findByCustomerId(id);
    }

    @Override
    public List<Invoice> findInvoiceByCoffeeShopId(Integer id){
        return invoiceRepository.findByCoffeeShopId(id);
    }
}
