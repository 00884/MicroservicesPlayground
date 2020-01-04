package com.itimoshin.spring_cloud_mastering.stock_service.domain.stock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/public/stock")
public class StockPublicController {

    private final StockService stockService;

    public StockPublicController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public Flux<StockItemEntity> getAll() {
        return stockService.getAll();
    }
}
