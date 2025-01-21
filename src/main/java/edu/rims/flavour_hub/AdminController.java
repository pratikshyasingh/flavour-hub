package edu.rims.flavour_hub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
   
@RequestMapping("/Admin")
public class AdminController {
    @GetMapping("/index")
    String adminIndex(){
        return "admin/index";
    }
    }    

