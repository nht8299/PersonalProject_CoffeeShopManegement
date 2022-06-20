package com.axonactive.coffeeshopmanagement.service.mapper;

import com.axonactive.coffeeshopmanagement.service.dto.InvoiceDetailDto;
import com.axonactive.coffeeshopmanagement.service.dto.InvoiceDto;
import com.axonactive.coffeeshopmanagement.entities.Invoice;
import com.axonactive.coffeeshopmanagement.entities.InvoiceDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    @Mapping(target = "customerName",source = "invoice.customer.fullName")
    @Mapping(target = "customerPhoneNumber",source = "invoice.customer.phoneNumber")
    @Mapping(target = "employeeFullName",expression = "java(invoice.getEmployee().getFirstName() + \" \" +invoice.getEmployee().getMiddleName()+\" \"+invoice.getEmployee().getLastName())")



    InvoiceDto toDto (Invoice invoice);
    List<InvoiceDto> toDtos (List<Invoice> invoices);
    @Mapping (target = "invoiceId",source = "invoiceDetail.invoice.id")
    @Mapping(target = "itemName",source = "invoiceDetail.item.name")
    @Mapping(target = "itemPrice",source = "invoiceDetail.item.price")
    InvoiceDetailDto toInvoiceDetailsDto (InvoiceDetail invoiceDetail);
    List<InvoiceDetailDto> toInvoiceDetailsDtos(List<InvoiceDetail> invoiceDetails);
}
