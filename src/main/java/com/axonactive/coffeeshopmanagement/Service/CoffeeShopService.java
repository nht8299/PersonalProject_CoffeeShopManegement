package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.entities.CoffeeShop;

import java.util.List;
import java.util.Optional;

public interface CoffeeShopService {

    List<CoffeeShop> getAll();

    CoffeeShop createCoffeeShop(CoffeeShop coffeeShop);

    Optional<CoffeeShop> findCoffeeShop(String name);

    void deleteCoffeeShop(String name);
}
