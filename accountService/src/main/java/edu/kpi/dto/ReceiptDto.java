package edu.kpi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ReceiptDto {

    private String id;
    private String orderId;
    private int totalPrice;
}
