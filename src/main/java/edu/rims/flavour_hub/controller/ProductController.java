package edu.rims.flavour_hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.flavour_hub.entity.Category;
import edu.rims.flavour_hub.entity.FoodItem;
import edu.rims.flavour_hub.repository.CategoryRepository;
import edu.rims.flavour_hub.repository.Food_itemRepository;

@Controller
public class ProductController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private Food_itemRepository Food_itemRepository;

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

    @GetMapping("/customer/pdp")
    String customerPdp() {
        return "customer/pdp";
    }

    @GetMapping("/customer/food_item/pdp")
    String getProductByFoodId(@RequestParam("food_item") String foodId, Model model) {
        FoodItem food_item = Food_itemRepository.findById(foodId).orElseThrow();
        model.addAttribute("food_item", food_item);
        return "customer/pdp";
    }

}