package edu.kpi.payments.web.rest;

import edu.kpi.payments.domain.Order;
import edu.kpi.payments.domain.Receipt;
import edu.kpi.payments.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentsController {

    private final PaymentService paymentService;

    @GetMapping
    public List<Receipt> readAll() {
        return paymentService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReceipt(@PathVariable String id) {
        Optional<Receipt> receiptOptional = paymentService.read(id);

        return receiptOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> processOrder(@RequestBody Order order) {
        Receipt receipt = paymentService.checkout(order);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(receipt.getId()).toUri();

        return ResponseEntity.created(location).body(receipt);
    }
}
