package edu.kpi.payments.service;

import edu.kpi.payments.domain.Order;
import edu.kpi.payments.domain.Receipt;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {

    private List<Receipt> receipts;

    @PostConstruct
    public void init() {
        receipts = new ArrayList<>();

        Receipt demo = Receipt.builder().id("demo-receipt").orderId("demo").totalPrice(23).build();
        receipts.add(demo);
    }

    public Receipt checkout(Order order) {
        int totalPrice = order.getItems().stream()
                .mapToInt(lineItem -> lineItem.getPrice() * lineItem.getQuantity())
                .sum();

        return Receipt.builder()
                .id(UUID.randomUUID().toString())
                .orderId(order.getId())
                .totalPrice(totalPrice)
                .build();
    }

    public Optional<Receipt> read(String id) {
        return receipts.stream()
                .filter(receipt -> receipt.getId().equals(id))
                .findFirst();
    }

    public List<Receipt> readAll() {
        return new ArrayList<>(receipts);
    }
}
