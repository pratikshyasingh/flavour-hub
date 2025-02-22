package edu.rims.flavour_hub.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import edu.rims.flavour_hub.entity.Category;
import edu.rims.flavour_hub.repository.CategoryRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller

public class AdminController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/admin/home")
    String adminHome() {
        return "admin/home";
    }

    @GetMapping("/admin/order")
    String adminOrder() {
        return "admin/order";
    }

    @GetMapping("/admin/customer")
    String adminCustomer() {
        return "admin/customer";
    }

    @GetMapping("/admin/category")
    String adminCategory(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "admin/category";
    }

    @PostMapping("/admin/category")
    public String categoryAdd(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/admin/category";
    }

    @GetMapping("/admin/product")
    String adminProduct() {
        return "admin/product";
    }

}