package edu.kpi.client;

import edu.kpi.dto.OrderDto;
import edu.kpi.dto.ReceiptDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("payments")
public interface PaymentsServiceClient {

    @PostMapping(path = "/api/payments", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ReceiptDto checkout(OrderDto order);
}
