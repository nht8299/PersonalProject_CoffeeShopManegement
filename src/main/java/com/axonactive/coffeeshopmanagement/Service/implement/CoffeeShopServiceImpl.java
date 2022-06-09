package com.axonactive.coffeeshopmanagement.Service.implement;

import com.axonactive.coffeeshopmanagement.Service.CoffeeShopService;
import com.axonactive.coffeeshopmanagement.entities.CoffeeShop;
import com.axonactive.coffeeshopmanagement.repositories.CoffeeShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoffeeShopServiceImpl implements CoffeeShopService {

    private final CoffeeShopRepository coffeeShopRepository;

    @Override
    public List<CoffeeShop> getAll() {
        return coffeeShopRepository.findAll();
    }

    @Override
    public CoffeeShop createCoffeeShop(CoffeeShop coffeeShop) {
        return coffeeShopRepository.save(coffeeShop);
    }

    @Override
    public Optional<CoffeeShop> findCoffeeShop(String name) {
        return coffeeShopRepository.findById(name);
    }

    @Override
    public void deleteCoffeeShop(String name) {
        coffeeShopRepository.deleteById(name);
    }
}
