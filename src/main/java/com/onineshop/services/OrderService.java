package com.onineshop.services;

import com.onineshop.config.ApiConfig;
import com.onineshop.dtos.OrderDTO;
import com.onineshop.dtos.ResponseDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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

    public ResponseDTO editById(int id, OrderDTO order) {
        String url = orderUrl + id;
        HttpEntity<OrderDTO> request = new HttpEntity<>(order);
        return restTemplate.exchange(
                url,
                HttpMethod.PUT,
                request,
                ResponseDTO.class
        ).getBody();
    }

    public ResponseDTO getList() {
        return restTemplate.getForObject(orderUrl, ResponseDTO.class);
    }

    public void deleteById(int id) {
        String url = orderUrl + id;
        restTemplate.delete(url);
    }
}
