package edu.rims.flavour_hub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
     @GetMapping("/admin")
    String adminHome() {
        return "customer/admin/home";
    }
}
