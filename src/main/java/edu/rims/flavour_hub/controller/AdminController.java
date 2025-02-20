package edu.rims.flavour_hub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @GetMapping("/admin")
    String adminHome() {
        return "admin/home";
    }

    @GetMapping("/admin/order")
    String adminOrder() {
        return "admin/order";
    }

    @GetMapping("/admin/customer")
    String adminCustomer() {
        return "admin/customer";
    }

    @GetMapping("/admin/category")
    String adminCategory() {
        return "admin/category";
    }

    @GetMapping("/admin/product")
    String adminProduct() {
        return "admin/product";
    }

}