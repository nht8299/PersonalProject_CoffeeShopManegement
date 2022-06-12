package com.axonactive.coffeeshopmanagement.Service.implement;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
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
    public Optional<CoffeeShop> findCoffeeShop(Integer id) {
        return coffeeShopRepository.findById(id);
    }

    @Override
    public void deleteCoffeeShop(Integer id) {
        coffeeShopRepository.deleteById(id);
    }

    @Override
    public CoffeeShop update(Integer id, CoffeeShop coffeeShopDetail) throws NotFoundException {
        CoffeeShop updateCoffeeShop = coffeeShopRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CoffeeShop Not Found: " + id));
        updateCoffeeShop.setName(coffeeShopDetail.getName());
        updateCoffeeShop.setLocation(coffeeShopDetail.getLocation());
        updateCoffeeShop.setPhoneNumber(coffeeShopDetail.getPhoneNumber());
        updateCoffeeShop.setHomepage(coffeeShopDetail.getHomepage());
        updateCoffeeShop.setAddress(coffeeShopDetail.getAddress());
        return coffeeShopRepository.save(updateCoffeeShop);
    }

    @Override
    public CoffeeShop findByName(String name) {
        return coffeeShopRepository.findByNameContaining(name);
    }
}
