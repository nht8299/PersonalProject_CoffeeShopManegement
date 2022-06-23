package com.axonactive.coffeeshopmanagement.service;

import com.axonactive.coffeeshopmanagement.exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.controller.request.ItemRequest;
import com.axonactive.coffeeshopmanagement.entities.Item;
import com.axonactive.coffeeshopmanagement.service.dto.ItemSalesDetailsDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<Item> getAll();

    Item createItem(ItemRequest requestItem) throws ResourceNotFoundException;

    Optional<Item> findItem(String id);

    void deleteItem(String id);

    Item findByNameContaining (String name);

    Item update(String id,ItemRequest requestItem) throws ResourceNotFoundException;

    List<ItemSalesDetailsDto> itemSalesDetailsOfOnePeriod(LocalDate date1, LocalDate date2);
}
