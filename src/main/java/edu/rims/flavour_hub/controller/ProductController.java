package edu.rims.flavour_hub.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.rims.flavour_hub.constant.FoodStatus;
import edu.rims.flavour_hub.entity.Category;
import edu.rims.flavour_hub.entity.FoodItem;
import edu.rims.flavour_hub.repository.CategoryRepository;
import edu.rims.flavour_hub.repository.Food_itemRepository;

@Controller
public class ProductController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private Food_itemRepository food_itemRepository;

    @GetMapping("/customer/category/plp")
    String getProductByCategoryId(@RequestParam("category") String categoryId, Model model) {
        Category category = categoryRepository.findCategoryByIdAndFoodItemStatus(categoryId, FoodStatus.AVAILABLE)
                .orElseThrow();
        model.addAttribute("category", category);
        return "customer/plp";
    }

    @GetMapping("/customer/food_item/pdp")
    String getProductByFoodId(@RequestParam("food_item") String foodId, Model model) {
        FoodItem food_item = food_itemRepository.findById(foodId).orElseThrow();
        model.addAttribute("food_item", food_item);
        return "customer/pdp";
    }

    @GetMapping("/product/search")
    String searchProduct(@RequestParam("search") String foodItemName, Model model) {
        List<FoodItem> foodItems = food_itemRepository.findByFoodNameContainingIgnoreCaseAndFoodItemStatus(foodItemName,
                FoodStatus.AVAILABLE);
        model.addAttribute("foodItems", foodItems);
        return "customer/plp";
    }

    @GetMapping(value = "/category/image/{categoryId}", produces = { "image/jpg", "image/png", "image/jpeg" })
    @ResponseBody
    byte[] getCategoryImage(@PathVariable String categoryId) throws IOException {
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        String categoryImageUrl = category.getCategoryImageUrl();
        if (categoryImageUrl != null && categoryImageUrl.startsWith("http")) {
            return null;
        }
        FileInputStream fis = new FileInputStream(categoryImageUrl);
        return fis.readAllBytes();
    }

    @GetMapping(value = "/foodItem/image/{foodItemId}", produces = { "image/jpg", "image/png", "image/jpeg" })
    @ResponseBody
    byte[] getfoodItemImage(@PathVariable String foodItemId) throws IOException {
        FoodItem foodItem = food_itemRepository.findById(foodItemId).orElseThrow();
        String foodItemImageUrl = foodItem.getFoodItemImageUrl();
        if (foodItemImageUrl != null && foodItemImageUrl.startsWith("http")) {
            return null;
        }
        FileInputStream fis = new FileInputStream(foodItemImageUrl);
        return fis.readAllBytes();
    }

}