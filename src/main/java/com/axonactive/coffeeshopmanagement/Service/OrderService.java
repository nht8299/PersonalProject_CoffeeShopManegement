package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.entities.Orders;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Orders> getAll();

    Orders createOrders(Orders orders);

    Optional<Orders> findOrder(Integer id);

    void deleteOrder(Integer id);

}
