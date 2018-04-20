package edu.kpi.ordermanagement.web.rest.resource;

import edu.kpi.ordermanagement.domain.Order;
import edu.kpi.ordermanagement.service.OrderManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController("/api/orders")
@RequiredArgsConstructor
public class OrderResource {

    private final OrderManagementService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> readOne(@PathVariable String id) {
        Optional<Order> orderOptional = service.read(id);

        return orderOptional.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Order> readAll() {
        return service.readAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Order order) {
        Order created = service.create(order);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(location).body(created);
    }
}
