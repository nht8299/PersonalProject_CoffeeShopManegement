package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.entities.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {

    List<OrderDetail> getAll();

    OrderDetail createOrderDetail(OrderDetail orderDetail);

    Optional<OrderDetail> findOrderDetail(Integer id);

    void deleteOrderDetail(Integer id);
}
