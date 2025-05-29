package com.onineshop.services;

import com.onineshop.config.ApiConfig;
import com.onineshop.dtos.OrderDTO;
import com.onineshop.dtos.ProductDTO;
import com.onineshop.dtos.ResponseDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    RestTemplate restTemplate = new RestTemplate();

    private final String productUrl;

    public ProductService(ApiConfig apiConfig) {
        this.productUrl = apiConfig.getBaseUrl() + "/products/";
    }

    public ResponseDTO create(ProductDTO product) {
        return restTemplate.postForObject(productUrl, product, ResponseDTO.class);
    }

    public ResponseDTO getById(int id) {
        String url = productUrl + id;
        return restTemplate.getForObject(url, ResponseDTO.class);
    }

    public ResponseDTO editById(int id, ProductDTO product) {
        String url = productUrl + id;
        HttpEntity<ProductDTO> request = new HttpEntity<>(product);
        return restTemplate.exchange(
                url,
                HttpMethod.PUT,
                request,
                ResponseDTO.class
        ).getBody();
    }

    public ResponseDTO getListByCategory(int id) {
        String url = productUrl + "?category=" + id;
        return restTemplate.getForObject(url, ResponseDTO.class);
    }

    public ResponseDTO getList() {
        return restTemplate.getForObject(productUrl, ResponseDTO.class);
    }

    public void deleteById(int id) {
        String url = productUrl + id;
        restTemplate.delete(url);
    }
}
