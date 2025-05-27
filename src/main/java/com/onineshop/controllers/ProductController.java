package com.onineshop.controllers;

import com.onineshop.dtos.ResponseDTO;
import com.onineshop.services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping({"", "/"})
    public String productList(HttpServletRequest request) {
        try {
            ResponseDTO product = productService.getList();
            if (product.isSuccess()) {
                request.setAttribute("products", product.getData());
                return "productList";
            }
            else {
                return "error404";
            }
        }
        catch (RestClientException e) {
            return "serverError";
        }
    }

    @GetMapping("/{id}")
    public String productDetails(@PathVariable int id, HttpServletRequest request) {
        try {
            ResponseDTO product = productService.getById(id);
            if (product.isSuccess()) {
                request.setAttribute("product", product.getData());
                return "productDetails";
            }
            else {
                return "error404";
            }
        }
        catch (RestClientException e) {
            return "serverError";
        }
    }
}
