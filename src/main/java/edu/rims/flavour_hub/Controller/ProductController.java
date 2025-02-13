package edu.rims.flavour_hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.flavour_hub.entity.Category;
import edu.rims.flavour_hub.repository.CategoryRepository;

@Controller
public class ProductController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/customer/plp")
    String customerPlp() {
        return "customer/plp";
    }

    @GetMapping("/customer/category/plp")
    String getProductByCategoryId(@RequestParam("category") String categoryId, Model model) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        model.addAttribute("category", category);
        return "customer/plp";
    }

}