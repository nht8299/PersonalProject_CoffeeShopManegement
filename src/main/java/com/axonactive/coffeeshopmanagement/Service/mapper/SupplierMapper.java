package com.axonactive.coffeeshopmanagement.Service.mapper;

import com.axonactive.coffeeshopmanagement.Service.dto.SupplierDto;
import com.axonactive.coffeeshopmanagement.entities.Supplier;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    SupplierDto toDto (Supplier supplier);
    List<SupplierDto> toDtos (List<Supplier> suppliers);
}
