package edu.kpi.ordermanagement.domain;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String id;
    private String accountId;

    @Singular
    private List<LineItem> items;
}
