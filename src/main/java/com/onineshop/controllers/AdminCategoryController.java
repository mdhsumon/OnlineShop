package com.onineshop.controllers;

import com.onineshop.dtos.CategoryDTO;
import com.onineshop.dtos.ResponseDTO;
import com.onineshop.services.CategoryService;
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
public class AdminCategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public String category(HttpServletRequest request) {
        try {
            ResponseDTO category = categoryService.getList();
            if (category.isSuccess()) {
                request.setAttribute("categories", category.getData());
                request.setAttribute("pCategory", true);
                return "admin/category";
            }
            else {
                return "error404";
            }
        }
        catch (RestClientException e) {
            return "serverError";
        }
    }

    @GetMapping("/category/create")
    public String categoryCreateForm(HttpServletRequest request) {
        request.setAttribute("pCategory", true);
        return "admin/categoryCreate";
    }

    @PostMapping("/category/create")
    public String categoryCreate(HttpServletRequest request) {
        try {
            CategoryDTO category = new CategoryDTO();
            category.setName(request.getParameter("name"));
            category.setDescription(request.getParameter("description"));
            category.setStatus(Integer.valueOf(request.getParameter("status")));

            categoryService.create(category);
            request.setAttribute("pCategory", true);
            return "redirect:/admin/category";
        }
        catch (RestClientException e) {
            return "serverError";
        }
    }

    @GetMapping("/category/{id}")
    public String categoryEditForm(@PathVariable int id, HttpServletRequest request) {
        try {
            ResponseDTO category = categoryService.getById(id);
            if (category.isSuccess()) {
                request.setAttribute("category", category.getData());
                request.setAttribute("pCategory", true);
                return "admin/categoryEdit";
            }
            else {
                return "error404";
            }
        }
        catch (RestClientException e) {
            return "serverError";
        }
    }

    @PostMapping("/category/{id}")
    public String categoryEdit(@PathVariable int id, HttpServletRequest request) {
        try {
            CategoryDTO category = new CategoryDTO();
            category.setName(request.getParameter("name"));
            category.setDescription(request.getParameter("description"));
            category.setStatus(Integer.valueOf(request.getParameter("status")));

            ResponseDTO response = categoryService.editById(id, category);
            if (response.isSuccess()) {
                request.setAttribute("pCategory", true);
                return "redirect:/admin/category";
            }
            else {
                return "error404";
            }
        }
        catch (RestClientException e) {
            return "serverError";
        }
    }

    @GetMapping("/category/delete/{id}")
    public String categoryDelete(@PathVariable int id, HttpServletRequest request) {
        try {
            categoryService.deleteById(id);
            request.setAttribute("pCategory", true);
            return "redirect:/admin/category";
        }
        catch (RestClientException e) {
            return "serverError";
        }
    }
}
