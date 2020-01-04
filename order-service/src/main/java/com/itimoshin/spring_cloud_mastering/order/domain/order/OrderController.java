package com.itimoshin.spring_cloud_mastering.order.domain.order;


import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;
    private final MongoOperations mongoOperations;

    public OrderController(OrderRepository orderRepository, MongoOperations mongoOperations) {
        this.orderRepository = orderRepository;
        this.mongoOperations = mongoOperations;
    }

    /*@PostMapping("sync")
    public OrderEntity testSync() {
        return orderRepository.save(new OrderEntity(Math.abs(new Random().nextLong())))
                .delayElement(Duration.ofSeconds(5)).block();
        //return Flux.just("").delayElements(Duration.ofSeconds(5)).last().block();
    }

    @PostMapping("async")
    public Mono<OrderEntity> testAsync() {
        return orderRepository.save(new OrderEntity(Math.abs(new Random().nextLong())))
                .delayElement(Duration.ofSeconds(5));
        //return Flux.just("").delayElements(Duration.ofSeconds(5)).last();
    }*/
}
