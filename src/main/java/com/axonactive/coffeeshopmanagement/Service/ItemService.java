package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.entities.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<Item> getAll();

    Item createItem(Item item);

    Optional<Item> findItem(String id);

    void deleteItem(String id);

    Item findByNameContaining (String name);

    Item update(String id,Item updateItem) throws NotFoundException;
}
