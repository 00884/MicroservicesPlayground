package com.itimoshin.spring_cloud_mastering.stock_service.domain.stock;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Flux<StockItemEntity> getAll() {
        return stockRepository.findAll();
    }

    @Override
    public Mono<Void> delete(Long id) {
        return stockRepository.deleteById(id);
    }

    @Override
    public Flux<StockItemEntity> getByIds(List<Long> ids) {
        return stockRepository.findAllById(ids);
    }

    @Override
    public Mono<StockItemEntity> save(StockItemEntity stockItemEntity) {
        return stockRepository.save(stockItemEntity);
    }
}
