package com.axonactive.coffeeshopmanagement.service;

import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.service.dto.DailyRevenueByInvoiceDto;
import com.axonactive.coffeeshopmanagement.service.dto.ItemSalesDetailsDto;
import com.axonactive.coffeeshopmanagement.service.dto.TotalRevenueOfPeriodTimeDto;
import com.axonactive.coffeeshopmanagement.api.request.InvoiceRequest;
import com.axonactive.coffeeshopmanagement.entities.Invoice;

import java.time.LocalDate;
import java.util.List;

public interface InvoiceService {

    List<Invoice> getAll();

    Invoice createInvoice(InvoiceRequest requestInvoice) throws ResourceNotFoundException;

    Invoice findInvoice(Integer id) throws ResourceNotFoundException;

    void deleteInvoice(Integer id);

    Invoice update(Integer id, InvoiceRequest requestInvoice) throws ResourceNotFoundException;

    boolean invoiceIsExist(Integer id);

    List<Invoice>findByDateBetween(LocalDate date1,LocalDate date2);

    List<DailyRevenueByInvoiceDto> DailyRevenueBetweenTwoDate(LocalDate date1,LocalDate date2);

    TotalRevenueOfPeriodTimeDto totalRevenueOfPeriodTime(LocalDate date1,LocalDate date2);


}


