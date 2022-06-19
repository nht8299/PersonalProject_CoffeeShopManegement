package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.api.request.ItemRequest;
import com.axonactive.coffeeshopmanagement.entities.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<Item> getAll();

    Item createItem(ItemRequest requestItem) throws ResourceNotFoundException;

    Optional<Item> findItem(String id);

    void deleteItem(String id);

    Item findByNameContaining (String name);

    Item update(String id,ItemRequest requestItem) throws ResourceNotFoundException;
}
