package edu.kpi.ordermanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Order {

    private String id;
    private String accountId;

    @Singular
    private List<LineItem> items;
}
