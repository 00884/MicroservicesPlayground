package com.itimoshin.spring_cloud_mastering.stock_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableR2dbcRepositories
public class StockServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(StockServiceApplication.class, args);
    }
}
