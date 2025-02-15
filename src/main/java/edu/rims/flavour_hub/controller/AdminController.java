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

}