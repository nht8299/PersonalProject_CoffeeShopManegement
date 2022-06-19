package com.axonactive.coffeeshopmanagement.repositories;

import com.axonactive.coffeeshopmanagement.entities.CoffeeShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoffeeShopRepository extends JpaRepository<CoffeeShop,Integer> {
    Optional<CoffeeShop> findByNameContaining(@Param("name")String name);
}
