package com.axonactive.coffeeshopmanagement.service.mapper;

import com.axonactive.coffeeshopmanagement.service.dto.CoffeeShopDto;
import com.axonactive.coffeeshopmanagement.entities.CoffeeShop;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoffeeShopMapper {

    CoffeeShopDto toDto(CoffeeShop coffeeShop);
    List<CoffeeShopDto> toDtos(List<CoffeeShop> coffeeShopList);
}
