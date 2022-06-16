package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.ReceiptsAndPaymentsService;
import com.axonactive.coffeeshopmanagement.Service.dto.ReceiptsAndPaymentsDto;
import com.axonactive.coffeeshopmanagement.Service.mapper.ReceiptsAndPaymentsMapper;
import com.axonactive.coffeeshopmanagement.api.request.ReceiptsAndPaymentRequest;
import com.axonactive.coffeeshopmanagement.entities.ReceiptsAndPayments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(value = "3600")
@RestController
@RequestMapping(ReceiptsAndPaymentsResource.PATH)
public class ReceiptsAndPaymentsResource {

    public static final String PATH = "/api/receipts&payments";

    @Autowired
    ReceiptsAndPaymentsService receiptsAndPaymentsService;

    @Autowired
    ReceiptsAndPaymentsMapper receiptsAndPaymentsMapper;

    @GetMapping
    public ResponseEntity<List<ReceiptsAndPaymentsDto>> getAll(){
        return ResponseEntity.ok(receiptsAndPaymentsMapper.toDtos(receiptsAndPaymentsService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceiptsAndPaymentsDto> findById(@PathVariable(value = "id")Integer id) throws NotFoundException {
        return ResponseEntity.ok(receiptsAndPaymentsMapper.toDto(receiptsAndPaymentsService.findById(id)
                .orElseThrow(() -> new NotFoundException("Receipts or payments not found with id: "+ id))));
    }

    @PostMapping
    public ResponseEntity<ReceiptsAndPaymentsDto> add(@RequestBody ReceiptsAndPaymentRequest receiptsAndPaymentRequest){
        ReceiptsAndPayments newReceiptsAndPayments = new ReceiptsAndPayments();
        newReceiptsAndPayments.setDescription(receiptsAndPaymentRequest.getDescription());
        newReceiptsAndPayments.setContent(receiptsAndPaymentRequest.getContent());
        newReceiptsAndPayments.setType(receiptsAndPaymentRequest.getType());
        newReceiptsAndPayments.setAmount(receiptsAndPaymentRequest.getAmount());
        ReceiptsAndPayments createReceiptsAndPayments = receiptsAndPaymentsService.create(newReceiptsAndPayments);
        return ResponseEntity.created(URI.create(ReceiptsAndPaymentsResource.PATH +"/"+createReceiptsAndPayments.getId()))
                .body(receiptsAndPaymentsMapper.toDto(createReceiptsAndPayments));
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id")Integer id){
        receiptsAndPaymentsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{/id}")
    public ResponseEntity<ReceiptsAndPaymentsDto> update(@PathVariable(value = "id")Integer id,@RequestBody ReceiptsAndPaymentRequest receiptsAndPaymentRequest) throws NotFoundException {
        ReceiptsAndPayments newReceiptsAndPayments = new ReceiptsAndPayments();
        newReceiptsAndPayments.setDescription(receiptsAndPaymentRequest.getDescription());
        newReceiptsAndPayments.setContent(receiptsAndPaymentRequest.getContent());
        newReceiptsAndPayments.setType(receiptsAndPaymentRequest.getType());
        newReceiptsAndPayments.setAmount(receiptsAndPaymentRequest.getAmount());
        return ResponseEntity.ok(receiptsAndPaymentsMapper.toDto(receiptsAndPaymentsService.update(id,newReceiptsAndPayments)));
    }
}
