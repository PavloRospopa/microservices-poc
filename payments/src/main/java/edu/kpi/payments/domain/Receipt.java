package edu.kpi.payments.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {

    private String id;
    private String orderId;
    private int totalPrice;
}
