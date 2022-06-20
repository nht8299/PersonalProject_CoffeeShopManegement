package com.axonactive.coffeeshopmanagement.Service.mapper;

import com.axonactive.coffeeshopmanagement.Service.dto.CoffeeShopDto;
import com.axonactive.coffeeshopmanagement.entities.CoffeeShop;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoffeeShopMapper {

    CoffeeShopDto toDto(CoffeeShop coffeeShop);
    List<CoffeeShopDto> toDtos(List<CoffeeShop> coffeeShopList);
}
