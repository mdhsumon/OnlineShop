package com.onineshop.controllers;

import com.onineshop.services.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

    @Autowired
    OrderService orderService;

    @GetMapping({"", "/"})
    public String dashboard(HttpServletRequest request) {
        request.setAttribute("pDashboard", true);
        return "admin/dashboard";
    }
}
