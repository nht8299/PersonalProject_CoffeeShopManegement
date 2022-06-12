package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.PaymentService;
import com.axonactive.coffeeshopmanagement.Service.dto.PaymentDto;
import com.axonactive.coffeeshopmanagement.Service.mapper.PaymentMapper;
import com.axonactive.coffeeshopmanagement.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PaymentResource.PATH)
public class PaymentResource {

    public static final String PATH = "/api/payment";

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentMapper paymentMapper;

    @GetMapping
    public ResponseEntity<List<PaymentDto>> getAll(){
        return ResponseEntity.ok(paymentMapper.toDtos(paymentService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> findPaymentById(@PathVariable(value = "id")Integer id) throws NotFoundException {
        return ResponseEntity.ok(paymentMapper.toDto(paymentService.findPayment(id)
                .orElseThrow(() -> new NotFoundException("Payment not found: "+id))));
    }

    @PostMapping
    public ResponseEntity<PaymentDto> add(@RequestBody PaymentRequest)
}
