package edu.rims.flavour_hub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/User")
public class UserController {
    @GetMapping("/index")
    String UserIndex(){
        return "User/index";
    }
    }    

