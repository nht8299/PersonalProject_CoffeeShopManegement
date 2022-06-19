package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
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

@CrossOrigin(value = "3600")
@RestController
@RequestMapping(ItemResource.PATH)
public class ItemResource {

    public static final String PATH = "/api/items";

    @Autowired
    ItemService itemService;

    @Autowired
    ItemMapper itemMapper;


    @GetMapping
    public ResponseEntity<List<ItemDto>> getAll(){
        return ResponseEntity.ok(itemMapper.toDtos(itemService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> findItemById(@PathVariable(value = "id")String id) throws ResourceNotFoundException {
        return ResponseEntity.ok(itemMapper.toDto(itemService.findItem(id)
                .orElseThrow( () -> new ResourceNotFoundException("Item not found: "+ id))));
    }

    @PostMapping
    public ResponseEntity<ItemDto> add(@RequestBody ItemRequest requestItem) throws ResourceNotFoundException {
        Item createItem = itemService.createItem(requestItem);
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
    public ResponseEntity<ItemDto> update(@PathVariable(value = "id")String id,@RequestBody ItemRequest requestItem) throws ResourceNotFoundException {
        return ResponseEntity.ok(itemMapper.toDto(itemService.update(id,requestItem)));
    }
}
