package edu.kpi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class OrderDto {
    private String id;
    private Long accountId;
    private List<LineItemDto> items;
}
