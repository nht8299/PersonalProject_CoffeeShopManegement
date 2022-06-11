package com.axonactive.coffeeshopmanagement.repositories;

import com.axonactive.coffeeshopmanagement.entities.CoffeeShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeShopRepository extends JpaRepository<CoffeeShop,Integer> {
    CoffeeShop findByName(String name);
}
