package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.CategoryService;
import com.axonactive.coffeeshopmanagement.Service.ItemService;
import com.axonactive.coffeeshopmanagement.Service.dto.ItemDto;
import com.axonactive.coffeeshopmanagement.Service.mapper.ItemMapper;
import com.axonactive.coffeeshopmanagement.api.request.ItemRequest;
import com.axonactive.coffeeshopmanagement.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(ItemResource.PATH)
public class ItemResource {

    public static final String PATH = "/api/item";

    @Autowired
    ItemService itemService;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<ItemDto>> getAll(){
        return ResponseEntity.ok(itemMapper.toDtos(itemService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> findItemById(@PathVariable(value = "id")String id) throws NotFoundException {
        return ResponseEntity.ok(itemMapper.toDto(itemService.findItem(id)
                .orElseThrow( () -> new NotFoundException("Item not found: "+ id))));
    }

    @PostMapping
    public ResponseEntity<ItemDto> add(@RequestBody ItemRequest requestItem){
        Item newItem = new Item();
        newItem.setId(requestItem.getId());
        newItem.setName(requestItem.getName());
        newItem.setStatus(requestItem.getStatus());
        newItem.setPrice(requestItem.getPrice());
        newItem.setCostRatePerUnit(requestItem.getCostRatePerUnit());
        newItem.setUnitInStock(requestItem.getUnitInStock());
        newItem.setCategory(categoryService.findByName(requestItem.getName()));
        Item createItem = itemService.createItem(newItem);
        return ResponseEntity
                .created(URI.create(ItemResource.PATH +"/" + createItem.getId()))
                .body(itemMapper.toDto(createItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable(value = "id")String id){
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> update(@PathVariable(value = "id")String id,@RequestBody ItemRequest requestItem) throws NotFoundException {
        Item updateItem = new Item();
        updateItem.setId(requestItem.getId());
        updateItem.setName(requestItem.getName());
        updateItem.setStatus(requestItem.getStatus());
        updateItem.setPrice(requestItem.getPrice());
        updateItem.setCostRatePerUnit(requestItem.getCostRatePerUnit());
        updateItem.setUnitInStock(requestItem.getUnitInStock());
        updateItem.setCategory(categoryService.findByName(requestItem.getName()));
        return ResponseEntity.ok(itemMapper.toDto(itemService.update(id,updateItem)));
    }
}
