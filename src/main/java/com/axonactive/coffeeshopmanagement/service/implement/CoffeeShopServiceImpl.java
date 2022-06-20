package com.axonactive.coffeeshopmanagement.service.implement;

import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.service.CoffeeShopService;
import com.axonactive.coffeeshopmanagement.api.request.CoffeeShopRequest;
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
    public CoffeeShop createCoffeeShop(CoffeeShopRequest requestCoffeeShop) {
        CoffeeShop newCoffeeShop = new CoffeeShop();
        newCoffeeShop.setName(requestCoffeeShop.getName());
        newCoffeeShop.setAddress(requestCoffeeShop.getAddress());
        newCoffeeShop.setHomepage(requestCoffeeShop.getHomepage());
        newCoffeeShop.setLocation(requestCoffeeShop.getLocation());
        newCoffeeShop.setPhoneNumber(requestCoffeeShop.getPhoneNumber());
        return coffeeShopRepository.save(newCoffeeShop);
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
    public CoffeeShop update(Integer id, CoffeeShopRequest requestCoffeeShop) throws ResourceNotFoundException {
        CoffeeShop updateCoffeeShop = coffeeShopRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CoffeeShop Not Found: " + id));
        updateCoffeeShop.setName(requestCoffeeShop.getName());
        updateCoffeeShop.setAddress(requestCoffeeShop.getAddress());
        updateCoffeeShop.setHomepage(requestCoffeeShop.getHomepage());
        updateCoffeeShop.setLocation(requestCoffeeShop.getLocation());
        updateCoffeeShop.setPhoneNumber(requestCoffeeShop.getPhoneNumber());
        return coffeeShopRepository.save(updateCoffeeShop);
    }

    @Override
    public Optional<CoffeeShop> findByName(String name) {
        return coffeeShopRepository.findByNameContaining(name);
    }
}
