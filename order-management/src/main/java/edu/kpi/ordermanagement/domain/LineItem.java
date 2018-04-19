package edu.kpi.ordermanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LineItem {

    private String name;
    private int quantity;
    private int price;
}
