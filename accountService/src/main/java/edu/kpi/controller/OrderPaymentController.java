package edu.kpi.controller;

import edu.kpi.client.OrderManagementServiceClient;
import edu.kpi.client.PaymentsServiceClient;
import edu.kpi.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accounts/{accountId}/orders")
public class OrderPaymentController {

    private final OrderManagementServiceClient orderManagementClient;
    private final PaymentsServiceClient paymentsClient;

    @GetMapping
    public List<OrderDto> fetchAccountOrders(@PathVariable("accountId") Long accountId) {
        return orderManagementClient.fetchAccountOrders(accountId);
    }

    @PostMapping("/{orderId}/checkout")
    public ResponseEntity<?> checkout(@PathVariable String orderId) {
        OrderDto order = orderManagementClient.read(orderId);

        return paymentsClient.checkout(order);
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@PathVariable Long accountId, @RequestBody OrderDto orderDto) {
        if (orderDto.getAccountId() != null && !orderDto.getAccountId().equals(accountId)) {
            return ResponseEntity.badRequest().build();
        }

        if (orderDto.getAccountId() == null) {
            orderDto.setAccountId(accountId);
        }

        return orderManagementClient.createOrder(orderDto);
    }
}
