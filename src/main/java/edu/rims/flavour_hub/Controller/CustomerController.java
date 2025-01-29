package edu.rims.flavour_hub.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class CustomerController {
    @GetMapping("/customer")
    String customerHome(){
        return "customer/home";
    }
    
    }
    
    
    

