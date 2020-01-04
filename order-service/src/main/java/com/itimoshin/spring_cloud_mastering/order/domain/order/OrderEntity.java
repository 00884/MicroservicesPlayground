package com.itimoshin.spring_cloud_mastering.order.domain.order;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collation = "order")
@Data
public class OrderEntity {

    @Id
    private Long id;
    private List <Long> stockElements;
}
