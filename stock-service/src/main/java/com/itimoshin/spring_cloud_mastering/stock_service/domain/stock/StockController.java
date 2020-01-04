package com.itimoshin.spring_cloud_mastering.stock_service.domain.stock;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    @PreAuthorize("hasRole()")
    public Mono<StockItemEntity> save(@RequestBody StockItemEntity stockItemEntity) {
        return stockService.save(stockItemEntity);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("permitAll()")
    public Mono<Void> delete(@PathVariable Long id) {
        return stockService.delete(id);
    }
}
