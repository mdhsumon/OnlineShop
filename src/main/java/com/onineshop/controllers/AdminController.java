package com.onineshop.controllers;

import com.onineshop.dtos.ResponseDTO;
import com.onineshop.services.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    OrderService orderService;

    @GetMapping({"", "/"})
    public String dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/order")
    public String order(HttpServletRequest request) {
        try {
            ResponseDTO order = orderService.getList();
            if (order.isSuccess()) {
                request.setAttribute("orders", order.getData());
                return "admin/order";
            }
            else {
                return "error404";
            }
        }
        catch (RestClientException e) {
            return "serverError";
        }
    }

    @GetMapping("/order/{id}")
    public String orderEditForm(@PathVariable int id, HttpServletRequest request) {
        try {
            ResponseDTO order = orderService.getById(id);
            if (order.isSuccess()) {
                request.setAttribute("order", order.getData());
                return "admin/orderEdit";
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
