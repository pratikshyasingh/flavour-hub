package edu.rims.flavour_hub.controller1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.rims.flavour_hub.entity.Category;
import edu.rims.flavour_hub.repository.CategoryRepository;

@Controller
public class CustomerController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/customer")
    String customerHome(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "customer/home";
    }
}
