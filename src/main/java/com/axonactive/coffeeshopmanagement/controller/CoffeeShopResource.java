package com.axonactive.coffeeshopmanagement.controller;

import com.axonactive.coffeeshopmanagement.exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.service.CoffeeShopService;
import com.axonactive.coffeeshopmanagement.service.dto.CoffeeShopDto;
import com.axonactive.coffeeshopmanagement.service.mapper.CoffeeShopMapper;
import com.axonactive.coffeeshopmanagement.controller.request.CoffeeShopRequest;
import com.axonactive.coffeeshopmanagement.entities.CoffeeShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@PreAuthorize("hasRole('MANAGER')")
@CrossOrigin(value = "3600")
@RestController
@RequestMapping(CoffeeShopResource.PATH)
public class CoffeeShopResource {

    public static final String PATH = "/api/coffee_shops";

    @Autowired
    CoffeeShopService coffeeShopService;

    @Autowired
    CoffeeShopMapper coffeeShopMapper;

    @GetMapping
    public ResponseEntity<List<CoffeeShopDto>> getAll() {
        return ResponseEntity.ok(coffeeShopMapper.toDtos(coffeeShopService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoffeeShopDto> findCoffeeShopById(@PathVariable(value = "id") Integer id, @RequestParam(value = "name", required = false) String name) throws ResourceNotFoundException {
        if (name == null) {
            return ResponseEntity.ok(coffeeShopMapper.toDto(coffeeShopService.findCoffeeShop(id)
                    .orElseThrow(() -> new ResourceNotFoundException("CoffeeShop not found: " + id))));
        }  return ResponseEntity.ok(coffeeShopMapper.toDto(coffeeShopService.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("CoffeeShop not found: "+name))));
    }


    @PostMapping
    public ResponseEntity<CoffeeShopDto> add(@RequestBody CoffeeShopRequest requestCoffeeShop) {
        CoffeeShop newCoffeeShop = coffeeShopService.createCoffeeShop(requestCoffeeShop);
        return ResponseEntity
                .created(URI.create(CoffeeShopResource.PATH + "/" + newCoffeeShop.getId()))
                .body(coffeeShopMapper.toDto(newCoffeeShop));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
        coffeeShopService.deleteCoffeeShop(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<CoffeeShopDto> update(@PathVariable(value = "id") Integer id, @RequestBody CoffeeShopRequest requestCoffeeShop) throws ResourceNotFoundException {
        return ResponseEntity.ok(coffeeShopMapper.toDto(coffeeShopService.update(id, requestCoffeeShop)));
    }
}
