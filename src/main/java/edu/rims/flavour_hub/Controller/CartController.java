package edu.rims.flavour_hub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
    @GetMapping("/customer/cart")
    String customerCart() {
        return "customer/cart";
    }
}
