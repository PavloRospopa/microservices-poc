package edu.kpi.client;

import edu.kpi.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("order-management")
public interface OrderManagementServiceClient {

    @RequestMapping(method = RequestMethod.GET, path = "/api/orders", params = "accountId")
    List<OrderDto> fetchAccountOrders(@RequestParam Long accountId);

    @RequestMapping(method = RequestMethod.GET, path = "/api/orders/{orderId}")
    OrderDto read(@PathVariable("orderId") String orderId);

    @RequestMapping(method = RequestMethod.POST, path = "/api/orders")
    ResponseEntity<OrderDto> createOrder(OrderDto orderDto);
}
