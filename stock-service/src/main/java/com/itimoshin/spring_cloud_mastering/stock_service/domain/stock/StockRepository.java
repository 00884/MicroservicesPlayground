package com.itimoshin.spring_cloud_mastering.stock_service.domain.stock;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends ReactiveCrudRepository<StockItemEntity, Long> {
}
