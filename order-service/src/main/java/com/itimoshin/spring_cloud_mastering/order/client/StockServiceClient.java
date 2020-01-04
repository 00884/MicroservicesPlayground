package com.itimoshin.spring_cloud_mastering.order.client;

import com.itimoshin.spring_cloud_mastering.order.dto.StockItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "stock-service")
public interface StockServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/stock/by-ids")
    List<StockItemDTO> getStockItems(List<Long> ids);

}
