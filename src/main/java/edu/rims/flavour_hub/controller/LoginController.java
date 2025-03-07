package edu.rims.flavour_hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.rims.flavour_hub.entity.User;
import edu.rims.flavour_hub.repository.UserRepository;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/customer/login")
    String customerLogin() {
        return "customer/login";
    }

    @PostMapping("/customer/sign-up")
    public String signUp(@ModelAttribute User user) {

        // user.setCreatedDate(LocalDateTime.now());
        // user.setUpdatedDate(LocalDateTime.now());
        // user.setCreatedBy("user");
        // user.setUpdatedBy("user");
        user.setUserPassword(encoder.encode(user.getUserPassword()));
        userRepository.save(user);
        return "redirect:/customer/login";
    }

}
