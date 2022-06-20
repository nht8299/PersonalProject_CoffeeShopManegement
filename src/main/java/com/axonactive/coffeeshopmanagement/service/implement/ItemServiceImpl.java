package com.axonactive.coffeeshopmanagement.service.implement;

import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.service.CategoryService;
import com.axonactive.coffeeshopmanagement.service.ItemService;
import com.axonactive.coffeeshopmanagement.api.request.ItemRequest;
import com.axonactive.coffeeshopmanagement.entities.Item;
import com.axonactive.coffeeshopmanagement.repositories.ItemRepository;
import com.axonactive.coffeeshopmanagement.service.dto.ItemSalesDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    private final CategoryService categoryService;

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item createItem(ItemRequest requestItem) throws ResourceNotFoundException {
        Item newItem = new Item();
        newItem.setId(requestItem.getId());
        newItem.setName(requestItem.getName());
        newItem.setStatus(requestItem.getStatus());
        newItem.setPrice(requestItem.getPrice());
        newItem.setCategory(categoryService.findCategory(requestItem.getCategoryId())
                .orElseThrow( () -> new ResourceNotFoundException("Category not found with id: "+requestItem.getCategoryId())));
        return itemRepository.save(newItem);
    }

    @Override
    public Optional<Item> findItem(String id) {
        return itemRepository.findById(id);
    }

    @Override
    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item findByNameContaining(String name) {
        return itemRepository.findByNameContaining(name);
    }

    @Override
    public Item update(String id, ItemRequest requestItem) throws ResourceNotFoundException {
         Item updateItem = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found: "+ id));
        updateItem.setId(requestItem.getId());
        updateItem.setName(requestItem.getName());
        updateItem.setStatus(requestItem.getStatus());
        updateItem.setPrice(requestItem.getPrice());
        updateItem.setCategory(categoryService.findCategory(requestItem.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: "+requestItem.getCategoryId())));
        return itemRepository.save(updateItem);
    }

    @Override
    public List<ItemSalesDetailsDto> itemSalesDetailsOfOnePeriod (LocalDate date1, LocalDate date2){
        return itemRepository.itemSalesDetailsOfOnePeriod(date1,date2);
    }
}
