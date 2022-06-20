package com.axonactive.coffeeshopmanagement.service.mapper;

import com.axonactive.coffeeshopmanagement.service.dto.ItemDto;
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
