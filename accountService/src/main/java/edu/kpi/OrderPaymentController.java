package edu.kpi;

import edu.kpi.client.OrderManagementServiceClient;
import edu.kpi.client.PaymentsServiceClient;
import edu.kpi.dto.OrderDto;
import edu.kpi.dto.ReceiptDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController("api/accounts/{accountId}/orders")
public class OrderPaymentController {

    private final OrderManagementServiceClient orderManagementClient;
    private final PaymentsServiceClient paymentsClient;

    @GetMapping
    public List<OrderDto> fetchAccountOrders(@PathVariable Long accountId) {
        return orderManagementClient.readAccountOrders(accountId);
    }


    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(String orderId) {
        OrderDto order = orderManagementClient.read(orderId);

        ReceiptDto receipt = paymentsClient.checkout(order);

        return ResponseEntity.ok(receipt);
    }

    @PostMapping
    public ResponseEntity<?> createOrder(OrderDto orderDto) {
        OrderDto created = orderManagementClient.createOrder(orderDto);

        return ResponseEntity.ok(created);
    }
}
