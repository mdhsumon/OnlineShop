package com.onineshop.services;

import com.onineshop.config.ApiConfig;
import com.onineshop.dtos.OrderDTO;
import com.onineshop.dtos.ResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    RestTemplate restTemplate = new RestTemplate();

    private final String orderUrl;

    public OrderService(ApiConfig apiConfig) {
        this.orderUrl = apiConfig.getBaseUrl() + "/orders/";
    }

    public ResponseDTO create(OrderDTO order) {
        return restTemplate.postForObject(orderUrl, order, ResponseDTO.class);
    }

    public ResponseDTO getById(int id) {
        String url = orderUrl + id;
        return restTemplate.getForObject(url, ResponseDTO.class);
    }

    public ResponseDTO getList() {
        return restTemplate.getForObject(orderUrl, ResponseDTO.class);
    }
}
