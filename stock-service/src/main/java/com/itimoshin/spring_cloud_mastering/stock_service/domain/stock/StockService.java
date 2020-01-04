package com.itimoshin.spring_cloud_mastering.stock_service.domain.stock;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StockService {

    Flux<StockItemEntity> getAll();

    Mono<Void> delete(Long id);

    Flux<StockItemEntity> getByIds(List<Long> ids);

    Mono<StockItemEntity> save(StockItemEntity stockItemEntity);
}
