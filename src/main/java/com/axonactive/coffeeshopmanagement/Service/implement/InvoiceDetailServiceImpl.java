package com.axonactive.coffeeshopmanagement.Service.implement;

import com.axonactive.coffeeshopmanagement.Service.InvoiceDetailService;
import com.axonactive.coffeeshopmanagement.entities.InvoiceDetail;
import com.axonactive.coffeeshopmanagement.repositories.InvoiceDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceDetailServiceImpl implements InvoiceDetailService {

    private final InvoiceDetailRepository orderDetailRepository;

    @Override
    public List<InvoiceDetail> getAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public InvoiceDetail createOrderDetail(InvoiceDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public Optional<InvoiceDetail> findOrderDetail(Integer id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public void deleteOrderDetail(Integer id) {
        orderDetailRepository.deleteById(id);
    }
}
