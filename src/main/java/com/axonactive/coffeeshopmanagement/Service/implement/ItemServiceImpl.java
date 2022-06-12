package com.axonactive.coffeeshopmanagement.Service.implement;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.ItemService;
import com.axonactive.coffeeshopmanagement.entities.Item;
import com.axonactive.coffeeshopmanagement.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
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
    public Item update(String id, Item updateItem) throws NotFoundException {
         Item item = itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Item not found: "+ id));
         item.setCategory(updateItem.getCategory());
         item.setName(updateItem.getName());
         item.setPrice(updateItem.getPrice());
         item.setStatus(updateItem.getStatus());
         item.setUnitInStock(updateItem.getUnitInStock());
         item.setCostRatePerUnit(updateItem.getCostRatePerUnit());
        return itemRepository.save(item);
    }
}
