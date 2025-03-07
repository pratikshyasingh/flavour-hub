package edu.rims.flavour_hub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping("/customer/orderhistory")
    String customerOrderhistory() {
        return "/customer/orderhistory";
    }

}
