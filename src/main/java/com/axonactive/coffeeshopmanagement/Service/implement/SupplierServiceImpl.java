package com.axonactive.coffeeshopmanagement.Service.implement;

import com.axonactive.coffeeshopmanagement.Service.SupplierService;
import com.axonactive.coffeeshopmanagement.entities.Supplier;
import com.axonactive.coffeeshopmanagement.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;


    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Optional<Supplier> findSupplier(Integer id) {
        return supplierRepository.findById(id);
    }

    @Override
    public void deleteSupplier(Integer id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public Supplier update(Integer id, Supplier updateSupplier) {
        Supplier supplier = new Supplier();
        supplier.setAddress(updateSupplier.getAddress());
        supplier.setCompanyName(updateSupplier.getCompanyName());
        supplier.setPhoneNumber(updateSupplier.getPhoneNumber());
        supplier.setHomePage(updateSupplier.getHomePage());
        supplier.setLocation(updateSupplier.getLocation());
        return supplierRepository.save(supplier);
    }
}
