package edu.rims.flavour_hub.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.rims.flavour_hub.entity.User;
import edu.rims.flavour_hub.repository.UserRepository;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/customer/login")
    String customerLogin() {
        return "customer/login";
    }

    @PostMapping("/customer/sign-up")
    public String signUp(@ModelAttribute User user) {
        user.setCreatedDate(LocalDateTime.now());
        user.setUpdatedDate(LocalDateTime.now());
        user.setCreatedBy("user");
        user.setUpdatedBy("user");
        userRepository.save(user);
        return "redirect:/customer/login";
    }

}
