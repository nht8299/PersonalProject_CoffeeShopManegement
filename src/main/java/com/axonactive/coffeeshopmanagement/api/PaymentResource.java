package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.EmployeeService;
import com.axonactive.coffeeshopmanagement.Service.PaymentService;
import com.axonactive.coffeeshopmanagement.Service.dto.PaymentDto;
import com.axonactive.coffeeshopmanagement.Service.mapper.PaymentMapper;
import com.axonactive.coffeeshopmanagement.api.request.PaymentRequest;
import com.axonactive.coffeeshopmanagement.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(PaymentResource.PATH)
public class PaymentResource {

    public static final String PATH = "/api/payment";

    @Autowired
    PaymentService PaymentService;

    @Autowired
    PaymentMapper PaymentMapper;

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<PaymentDto>> getAll(){
        return ResponseEntity.ok(PaymentMapper.toDtos(PaymentService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> findPaymentById(@PathVariable(value = "id")Integer id) throws NotFoundException {
        return ResponseEntity.ok(PaymentMapper.toDto(PaymentService.findPayment(id)
                .orElseThrow(() -> new NotFoundException("Payment not found: "+id))));
    }

    @PostMapping
    public ResponseEntity<PaymentDto> add(@RequestBody PaymentRequest requestPayment){
        Payment newPayment = new Payment();
        newPayment.setBonus(requestPayment.getBonus());
        newPayment.setDate(requestPayment.getDate());
        newPayment.setRole(requestPayment.getRole());
        newPayment.setEmployeeType(requestPayment.getEmployeeType());
        newPayment.setSalary(requestPayment.getSalary());
        newPayment.setEmployee(employeeService.findByPhoneNumber(requestPayment.getEmployeePhoneNumber()));
        Payment createPayment = PaymentService.createPayment(newPayment);
        return ResponseEntity
                .created(URI.create(PaymentResource.PATH+"/"+ createPayment.getId()))
                .body(PaymentMapper.toDto(createPayment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id")Integer id){
        PaymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDto> update(@PathVariable(value = "id")Integer id, @RequestBody PaymentRequest requestPayment){
        Payment updatePayment = new Payment();
        updatePayment.setBonus(requestPayment.getBonus());
        updatePayment.setDate(requestPayment.getDate());
        updatePayment.setRole(requestPayment.getRole());
        updatePayment.setEmployeeType(requestPayment.getEmployeeType());
        updatePayment.setSalary(requestPayment.getSalary());
        updatePayment.setEmployee(employeeService.findByPhoneNumber(requestPayment.getEmployeePhoneNumber()));
        return ResponseEntity.ok(PaymentMapper.toDto(PaymentService.update(id, updatePayment)));
    }
}
