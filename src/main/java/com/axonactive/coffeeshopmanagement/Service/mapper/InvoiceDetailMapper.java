package com.axonactive.coffeeshopmanagement.Service.mapper;

import com.axonactive.coffeeshopmanagement.Service.dto.InvoiceDetailDto;
import com.axonactive.coffeeshopmanagement.entities.InvoiceDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceDetailMapper {

    @Mapping (target = "invoiceId",source = "invoiceDetail.invoice.id")
    @Mapping(target = "itemName",source = "invoiceDetail.item.name")
    @Mapping(target = "itemPrice",source = "invoiceDetail.item.price")

    InvoiceDetailDto toDto (InvoiceDetail invoiceDetail);
    List<InvoiceDetailDto> toDtos(List<InvoiceDetail> invoiceDetails);
}
