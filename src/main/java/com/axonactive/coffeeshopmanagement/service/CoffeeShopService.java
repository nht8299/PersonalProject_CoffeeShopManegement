package com.axonactive.coffeeshopmanagement.service;

import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.api.request.CoffeeShopRequest;
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
