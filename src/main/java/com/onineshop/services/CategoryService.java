package com.onineshop.services;

import com.onineshop.config.ApiConfig;
import com.onineshop.dtos.ResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CategoryService {
    RestTemplate restTemplate = new RestTemplate();

    private final String categoryUrl;

    public CategoryService(ApiConfig apiConfig) {
        this.categoryUrl = apiConfig.getBaseUrl() + "/categories/";
    }

    public ResponseDTO getById(int id) {
        String url = categoryUrl + id;
        return restTemplate.getForObject(url, ResponseDTO.class);
    }

    public ResponseDTO getList() {
        return restTemplate.getForObject(categoryUrl, ResponseDTO.class);
    }
}
