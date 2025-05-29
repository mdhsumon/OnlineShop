package com.onineshop.services;

import com.onineshop.config.ApiConfig;
import com.onineshop.dtos.CategoryDTO;
import com.onineshop.dtos.ProductDTO;
import com.onineshop.dtos.ResponseDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CategoryService {
    RestTemplate restTemplate = new RestTemplate();

    private final String categoryUrl;

    public CategoryService(ApiConfig apiConfig) {
        this.categoryUrl = apiConfig.getBaseUrl() + "/categories/";
    }

    public ResponseDTO create(CategoryDTO category) {
        return restTemplate.postForObject(categoryUrl, category, ResponseDTO.class);
    }

    public ResponseDTO getById(int id) {
        String url = categoryUrl + id;
        return restTemplate.getForObject(url, ResponseDTO.class);
    }

    public ResponseDTO editById(int id, CategoryDTO category) {
        String url = categoryUrl + id;
        HttpEntity<CategoryDTO> request = new HttpEntity<>(category);
        return restTemplate.exchange(
                url,
                HttpMethod.PUT,
                request,
                ResponseDTO.class
        ).getBody();
    }

    public ResponseDTO getList() {
        return restTemplate.getForObject(categoryUrl, ResponseDTO.class);
    }

    public void deleteById(int id) {
        String url = categoryUrl + id;
        restTemplate.delete(url);
    }
}
