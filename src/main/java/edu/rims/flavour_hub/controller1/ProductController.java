package edu.rims.flavour_hub.controller1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping("/customer/plp")
    String customerPlp() {
        return "customer/plp";
    }
}