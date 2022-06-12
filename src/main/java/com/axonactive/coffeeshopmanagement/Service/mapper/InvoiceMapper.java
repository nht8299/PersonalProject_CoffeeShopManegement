package com.axonactive.coffeeshopmanagement.Service.mapper;

import com.axonactive.coffeeshopmanagement.Service.dto.InvoiceDto;
import com.axonactive.coffeeshopmanagement.entities.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    @Mapping(target = "customerName",source = "invoice.customer.fullName")
    @Mapping(target = "customerPhoneNumber",source = "invoice.customer.phoneNumber")
    @Mapping(target = "enployeeFullName",expression = "java(invoice.employee().getFirstName() + \" \" +invoice.employee().getMiddleName+\" \"+invoice.employee().getLastName())")
    @Mapping(target = "orderDetailDtos",expression = "")

    InvoiceDto toDto (Invoice invoice);
    List<InvoiceDto> toDtos (List<Invoice> invoices);
}
