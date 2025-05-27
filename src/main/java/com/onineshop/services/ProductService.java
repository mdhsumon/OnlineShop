package com.onineshop.services;

import com.onineshop.config.ApiConfig;
import com.onineshop.dtos.ResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    RestTemplate restTemplate = new RestTemplate();

    private final String productUrl;

    public ProductService(ApiConfig apiConfig) {
        this.productUrl = apiConfig.getBaseUrl() + "/products/";
    }

    public ResponseDTO getById(int id) {
        String url = productUrl + id;
        return restTemplate.getForObject(url, ResponseDTO.class);
    }

    public ResponseDTO getList() {
        return restTemplate.getForObject(productUrl, ResponseDTO.class);
    }
}
