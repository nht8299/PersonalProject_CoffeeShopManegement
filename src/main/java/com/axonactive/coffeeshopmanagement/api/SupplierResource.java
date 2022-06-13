package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.SupplierService;
import com.axonactive.coffeeshopmanagement.Service.dto.SupplierDto;
import com.axonactive.coffeeshopmanagement.Service.mapper.SupplierMapper;
import com.axonactive.coffeeshopmanagement.api.request.SupplierRequest;
import com.axonactive.coffeeshopmanagement.entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(SupplierResource.PATH)
public class SupplierResource {

    public static final String PATH = "/api/supplier";

    @Autowired
    SupplierService supplierService;

    @Autowired
    SupplierMapper supplierMapper;

    @GetMapping
    public ResponseEntity<List<SupplierDto>> getAll(){
        return ResponseEntity.ok(supplierMapper.toDtos(supplierService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDto> findById(@PathVariable(value = "id")Integer id) throws NotFoundException {
        return ResponseEntity.ok(supplierMapper.toDto(supplierService.findSupplier(id)
                .orElseThrow( () -> new NotFoundException("Supplier not found" + id))));
    }

    @PostMapping
    public ResponseEntity<SupplierDto> add(@RequestBody SupplierRequest requestSupplier){
        Supplier newSupplier = new Supplier();
        newSupplier.setAddress(requestSupplier.getAddress());
        newSupplier.setCompanyName(requestSupplier.getCompanyName());
        newSupplier.setPhoneNumber(requestSupplier.getPhoneNumber());
        newSupplier.setHomePage(requestSupplier.getHomePage());
        newSupplier.setLocation(requestSupplier.getLocation());
        Supplier createSupplier = supplierService.createSupplier(newSupplier);
        return ResponseEntity
                .created(URI.create(SupplierResource.PATH+"/"+createSupplier.getId()))
                .body(supplierMapper.toDto(createSupplier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id")Integer id){
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<SupplierDto> update(@PathVariable(value = "id")Integer id,@RequestBody SupplierRequest requestSupplier){
        Supplier updateSupplier = new Supplier();
        updateSupplier.setAddress(requestSupplier.getAddress());
        updateSupplier.setCompanyName(requestSupplier.getCompanyName());
        updateSupplier.setPhoneNumber(requestSupplier.getPhoneNumber());
        updateSupplier.setHomePage(requestSupplier.getHomePage());
        updateSupplier.setLocation(requestSupplier.getLocation());
        return ResponseEntity.ok(supplierMapper.toDto(supplierService.update(id,updateSupplier)));
    }

}
