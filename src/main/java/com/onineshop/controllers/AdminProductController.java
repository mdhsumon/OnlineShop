package com.onineshop.controllers;

import com.onineshop.dtos.ProductDTO;
import com.onineshop.dtos.ResponseDTO;
import com.onineshop.services.CategoryService;
import com.onineshop.services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;

@Controller
@RequestMapping("/admin")
public class AdminProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/product")
    public String product(HttpServletRequest request) {
        try {
            ResponseDTO product = productService.getList();
            if (product.isSuccess()) {
                request.setAttribute("products", product.getData());
                request.setAttribute("pProduct", true);
                return "admin/product";
            }
            else {
                return "error404";
            }
        }
        catch (RestClientException e) {
            return "serverError";
        }
    }

    @GetMapping("/product/create")
    public String productCreateForm(HttpServletRequest request) {
        ResponseDTO response = categoryService.getList();
        request.setAttribute("categories", response.getData());
        request.setAttribute("pProduct", true);
        return "admin/productCreate";
    }

    @PostMapping("/product/create")
    public String productCreate(HttpServletRequest request) {
        try {
            ProductDTO product = new ProductDTO();
            product.setName(request.getParameter("name"));
            product.setDescription(request.getParameter("description"));
            product.setPrice(Double.parseDouble(request.getParameter("price")));
            product.setCategoryId(Integer.valueOf(request.getParameter("categoryId")));
            product.setStatus(Integer.valueOf(request.getParameter("status")));

            productService.create(product);
            request.setAttribute("pProduct", true);
            return "redirect:/admin/product";
        }
        catch (RestClientException e) {
            return "serverError";
        }
    }

    @GetMapping("/product/{id}")
    public String productEditForm(@PathVariable int id, HttpServletRequest request) {
        try {
            ResponseDTO product = productService.getById(id);
            if (product.isSuccess()) {
                ResponseDTO response = categoryService.getList();
                request.setAttribute("categories", response.getData());
                request.setAttribute("product", product.getData());
                request.setAttribute("pProduct", true);
                return "admin/productEdit";
            }
            else {
                return "error404";
            }
        }
        catch (RestClientException e) {
            return "serverError";
        }
    }

    @PostMapping("/product/{id}")
    public String productEdit(@PathVariable int id, HttpServletRequest request) {
        try {
            ProductDTO product = new ProductDTO();
            product.setName(request.getParameter("name"));
            product.setDescription(request.getParameter("description"));
            product.setPrice(Double.parseDouble(request.getParameter("price")));
            product.setCategoryId(Integer.valueOf(request.getParameter("categoryId")));
            product.setStatus(Integer.valueOf(request.getParameter("status")));

            ResponseDTO response = productService.editById(id, product);
            if (response.isSuccess()) {
                request.setAttribute("pProduct", true);
                return "redirect:/admin/product";
            }
            else {
                return "error404";
            }
        }
        catch (RestClientException e) {
            return "serverError";
        }
    }

    @GetMapping("/product/delete/{id}")
    public String productDelete(@PathVariable int id, HttpServletRequest request) {
        try {
            productService.deleteById(id);
            request.setAttribute("pProduct", true);
            return "redirect:/admin/product";
        }
        catch (RestClientException e) {
            return "serverError";
        }
    }
}
