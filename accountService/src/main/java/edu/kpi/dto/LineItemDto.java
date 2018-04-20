package edu.kpi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LineItemDto {

    private String name;
    private int quantity;
    private int price;
}
