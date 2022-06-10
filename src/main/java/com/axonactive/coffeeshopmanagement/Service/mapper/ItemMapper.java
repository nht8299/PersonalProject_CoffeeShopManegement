package com.axonactive.coffeeshopmanagement.Service.mapper;

import com.axonactive.coffeeshopmanagement.Service.dto.EmployeeDto;
import com.axonactive.coffeeshopmanagement.Service.dto.ItemDto;
import com.axonactive.coffeeshopmanagement.entities.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(target = "categoryName",source = "item.category.name")

    ItemDto toDto (Item item);

    List<ItemDto> toDtos (List<Item> items);

}
