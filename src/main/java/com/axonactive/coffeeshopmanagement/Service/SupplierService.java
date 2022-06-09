package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.entities.Supplier;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface SupplierService {

    List<Supplier> getAll();

    Supplier createSupplier(Supplier supplier);

    Optional<Supplier> findSupplier(Integer id);

    void deleteSupplier(Integer id);
}
