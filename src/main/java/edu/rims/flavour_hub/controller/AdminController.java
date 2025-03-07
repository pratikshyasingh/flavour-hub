package edu.rims.flavour_hub.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import edu.rims.flavour_hub.entity.Category;
import edu.rims.flavour_hub.entity.FoodItem;
import edu.rims.flavour_hub.repository.CategoryRepository;
import edu.rims.flavour_hub.repository.Food_itemRepository;

import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller

public class AdminController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private Food_itemRepository food_itemRepository;

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
    public String categoryAdd(@ModelAttribute Category category,
            @RequestParam("categoryImageFile") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));

            String fileName = "upload_images/" + UUID.randomUUID().toString() + extName;

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();
            category.setCategoryImageUrl(fileName);

        }
        categoryRepository.save(category);
        return "redirect:/admin/category";
    }

    @GetMapping("/admin/product")
    String adminProduct(Model model) {
        List<Category> categories = categoryRepository.findAll();
        List<FoodItem> foodItems = food_itemRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("foodItems", foodItems);
        return "admin/product";
    }

    @PostMapping("/admin/product")
    public String productAdd(@ModelAttribute FoodItem foodItem, @RequestParam String categoryId,
            @RequestParam("foodItemImageFile") MultipartFile file) throws IOException {
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        foodItem.setCategory(category);
        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));

            String fileName = "upload_images/" + UUID.randomUUID().toString() + extName;

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();
            foodItem.setFoodItemImageUrl(fileName);

        }
        food_itemRepository.save(foodItem);
        return "redirect:/admin/product";
    }

}