package edu.kpi.client;

import edu.kpi.dto.OrderDto;
import edu.kpi.dto.ReceiptDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("payments")
public interface PaymentsServiceClient {

    @RequestMapping(method = RequestMethod.POST, path = "/api/payments")
    ResponseEntity<ReceiptDto> checkout(OrderDto order);
}
