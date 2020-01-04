package com.itimoshin.spring_cloud_mastering.stock_service.domain.stock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("stock_item")
@AllArgsConstructor
@NoArgsConstructor
public class StockItemEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;
}
