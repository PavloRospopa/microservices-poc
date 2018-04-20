package edu.kpi.client;

import edu.kpi.dto.OrderDto;
import org.hibernate.criterion.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("order-management")
public interface OrderManagementServiceClient {

    @RequestMapping(method = RequestMethod.GET,
            path = "/api/orders",
            params = "accountId")
    List<OrderDto> readAccountOrders(@RequestParam Long accountId);

    @GetMapping(path = "/api/orders/{orderId}")
    OrderDto read(@PathVariable String orderId);

    @PostMapping(path = "/api/orders")
    OrderDto createOrder(OrderDto orderDto);
}
