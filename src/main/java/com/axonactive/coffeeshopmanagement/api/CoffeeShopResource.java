package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.CoffeeShopService;
import com.axonactive.coffeeshopmanagement.Service.dto.CoffeeShopDto;
import com.axonactive.coffeeshopmanagement.Service.mapper.CoffeeShopMapper;
import com.axonactive.coffeeshopmanagement.api.request.CoffeeShopRequest;
import com.axonactive.coffeeshopmanagement.entities.CoffeeShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(value = "3600")
@RestController
@RequestMapping(CoffeeShopResource.PATH)
public class CoffeeShopResource {

    public static final String PATH = "/api/coffeeshop";

    @Autowired
    CoffeeShopService coffeeShopService;

    @Autowired
    CoffeeShopMapper coffeeShopMapper;

    @GetMapping
    public ResponseEntity<List<CoffeeShopDto>> getAll() {
        return ResponseEntity.ok(coffeeShopMapper.toDtos(coffeeShopService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoffeeShopDto> findCoffeeShopById(@PathVariable(value = "id") Integer id, @RequestParam(value = "name", required = false) String name) throws NotFoundException {
        if (name == null) {
            return ResponseEntity.ok(coffeeShopMapper.toDto(coffeeShopService.findCoffeeShop(id)
                    .orElseThrow(() -> new NotFoundException("CoffeeShop not found: " + id))));
        }  return ResponseEntity.ok(coffeeShopMapper.toDto(coffeeShopService.findByName(name)
                .orElseThrow(() -> new NotFoundException("CoffeeShop not found: "+name))));
    }


    @PostMapping
    public ResponseEntity<CoffeeShopDto> add(@RequestBody CoffeeShop requestCoffeeShop) {
        CoffeeShop newCoffeeShop = new CoffeeShop();
        newCoffeeShop.setName(requestCoffeeShop.getName());
        newCoffeeShop.setAddress(requestCoffeeShop.getAddress());
        newCoffeeShop.setHomepage(requestCoffeeShop.getHomepage());
        newCoffeeShop.setLocation(requestCoffeeShop.getLocation());
        newCoffeeShop.setPhoneNumber(requestCoffeeShop.getPhoneNumber());
        CoffeeShop createCoffeeShop = coffeeShopService.createCoffeeShop(newCoffeeShop);
        return ResponseEntity
                .created(URI.create(CoffeeShopResource.PATH + "/" + createCoffeeShop.getId()))
                .body(coffeeShopMapper.toDto(createCoffeeShop));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
        coffeeShopService.deleteCoffeeShop(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<CoffeeShopDto> update(@PathVariable(value = "id") Integer id, @RequestBody CoffeeShopRequest requestCoffeeShop) throws NotFoundException {
        CoffeeShop updateCoffeeShop = new CoffeeShop();
        updateCoffeeShop.setName(requestCoffeeShop.getName());
        updateCoffeeShop.setAddress(requestCoffeeShop.getAddress());
        updateCoffeeShop.setHomepage(requestCoffeeShop.getHomepage());
        updateCoffeeShop.setLocation(requestCoffeeShop.getLocation());
        updateCoffeeShop.setPhoneNumber(requestCoffeeShop.getPhoneNumber());
        return ResponseEntity.ok(coffeeShopMapper.toDto(coffeeShopService.update(id, updateCoffeeShop)));
    }
}
