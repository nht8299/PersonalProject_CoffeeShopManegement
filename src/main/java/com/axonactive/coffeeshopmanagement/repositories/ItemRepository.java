package com.axonactive.coffeeshopmanagement.repositories;

import com.axonactive.coffeeshopmanagement.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item,String> {

    Item findByNameContaining(@Param(value = "name") String name);
}
