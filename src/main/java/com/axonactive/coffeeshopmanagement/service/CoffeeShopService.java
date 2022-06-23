package com.axonactive.coffeeshopmanagement.service;

import com.axonactive.coffeeshopmanagement.exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.controller.request.CoffeeShopRequest;
import com.axonactive.coffeeshopmanagement.entities.CoffeeShop;

import java.util.List;
import java.util.Optional;

public interface CoffeeShopService {

    List<CoffeeShop> getAll();

    CoffeeShop createCoffeeShop(CoffeeShopRequest requestCoffeeShop);

    Optional<CoffeeShop> findCoffeeShop(Integer id);

    void deleteCoffeeShop(Integer id);

    CoffeeShop update(Integer id,CoffeeShopRequest coffeeShopDetail) throws ResourceNotFoundException;

    Optional<CoffeeShop> findByName (String name);
}
