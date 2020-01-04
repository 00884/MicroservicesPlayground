package com.itimoshin.spring_cloud_mastering.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockItemDTO {
    private final Long id;
    private final String name;
}
