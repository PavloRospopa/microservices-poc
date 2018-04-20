package edu.kpi.payments.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Order {
    private String id;
    private List<LineItem> items;
}
