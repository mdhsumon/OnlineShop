package com.onineshop.controllers;

import com.onineshop.dtos.OrderDTO;
import com.onineshop.dtos.ResponseDTO;
import com.onineshop.services.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

@Controller
@RequestMapping("/admin")
public class AdminOrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public String order(HttpServletRequest request) {
        try {
            ResponseDTO order = orderService.getList();
            if (order.isSuccess()) {
                request.setAttribute("orders", order.getData());
                request.setAttribute("pOrder", true);
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
                request.setAttribute("pOrder", true);
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

    @PostMapping("/order/{id}")
    public String orderEdit(@PathVariable int id, HttpServletRequest request) {
        try {
            OrderDTO order = new OrderDTO();
            order.setCustomerName(request.getParameter("customerName"));
            order.setCustomerPhone(request.getParameter("customerPhone"));
            order.setCustomerAddress(request.getParameter("customerAddress"));
            ResponseDTO response = orderService.editById(id, order);
            if (response.isSuccess()) {
                request.setAttribute("pOrder", true);
                return "redirect:/admin/order";
            }
            else {
                return "error404";
            }
        }
        catch (RestClientException e) {
            return "serverError";
        }
    }

    @GetMapping("/order/delete/{id}")
    public String orderDeletet(@PathVariable int id, HttpServletRequest request) {
        try {
            orderService.deleteById(id);
            request.setAttribute("pOrder", true);
            return "redirect:/admin/order";
        }
        catch (RestClientException e) {
            return "serverError";
        }
    }
}
