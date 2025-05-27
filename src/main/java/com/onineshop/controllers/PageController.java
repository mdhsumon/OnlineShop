package com.onineshop.controllers;

import com.onineshop.dtos.OrderDTO;
import com.onineshop.dtos.ResponseDTO;
import com.onineshop.services.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;

@Controller
public class PageController {

    @Autowired
    OrderService orderService;

    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }

    @GetMapping("/checkout")
    public String checkout(@RequestParam String productId, HttpServletRequest request) {
        request.setAttribute("productId", productId);
        return "checkout";
    }

    @PostMapping("/orders")
    public String checkout(HttpServletRequest request) {
        try {
            OrderDTO newOrder = new OrderDTO();
            newOrder.setProductId(Integer.valueOf(request.getParameter("productId")));
            newOrder.setCustomerName(request.getParameter("customerName"));
            newOrder.setCustomerEmail(request.getParameter("customerEmail"));
            newOrder.setCustomerPhone(request.getParameter("customerPhone"));
            newOrder.setCustomerAddress(request.getParameter("customerAddress"));
            newOrder.setPaymentMethod((Integer) request.getAttribute("paymentMethod"));
            ResponseDTO order = orderService.create(newOrder);
            if (order.isSuccess()) {
                request.setAttribute("order", order.getData());
                return "orderCreated";
            }
        }
        catch (RestClientException e) {
            return "serverError";
        }
        return "checkout";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}
