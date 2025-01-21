package edu.rims.flavour_hub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


    @Controller
public class ProductController {
    @GetMapping("/index")
    String index() {
        return "index";
    }
    
    
        
    
}
