package edu.rims.flavour_hub.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import edu.rims.flavour_hub.constant.FoodStatus;
import edu.rims.flavour_hub.constant.WidgetStatus;
import edu.rims.flavour_hub.entity.Category;
import edu.rims.flavour_hub.entity.FoodItem;
import edu.rims.flavour_hub.entity.Order;
import edu.rims.flavour_hub.entity.Widget;
import edu.rims.flavour_hub.repository.CategoryRepository;
import edu.rims.flavour_hub.repository.Food_itemRepository;
import edu.rims.flavour_hub.repository.OrderRepository;
import edu.rims.flavour_hub.repository.WidgetRepository;

import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestBody;

@Controller

public class AdminController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private Food_itemRepository food_itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WidgetRepository widgetRepository;

    @GetMapping("/admin/home")
    String adminHome() {
        return "admin/home";
    }

    @GetMapping("/admin/order")
    String adminOrder(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
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

    @GetMapping("/admin/product/remove")
    public String removeFoodItem(@RequestParam("product") String itemId) {
        FoodItem foodItem = food_itemRepository.findById(itemId).orElseThrow();
        foodItem.setFoodItemStatus(FoodStatus.UNAVAILABLE);
        food_itemRepository.save(foodItem);
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/widget")
    public String getWidgets(Model model) {
        model.addAttribute("widgets", widgetRepository.findAll());
        return "admin/widget";
    }

    @PostMapping("/admin/widget/add")
    public String postMethodName(@RequestParam String widgetName, @RequestParam String widgetId) {
        Widget widget = new Widget();

        if (widgetId != null && widgetId.isEmpty()) {
            widget.setWidgetId(widgetId);
        }
        System.out.println("value of:" + widgetId);
        widget.setWidgetName((widgetName));
        widget.setUpdatedDate(LocalDateTime.now());
        widgetRepository.save(widget);
        return "redirect:/admin/widget";
    }

    @GetMapping("/admin/widget/remove")
    public String removeWidget(@RequestParam("id") String widgetId) {
        Widget widget = widgetRepository.findById(widgetId).orElseThrow();
        widget.setWidgetStatus(WidgetStatus.UNAVAILABLE);
        widgetRepository.save(widget);

        return "redirect:/admin/widget";
    }

    @GetMapping("/admin/widget/edit")
    public String editWidget(@RequestParam("id") String widgetId, Model model) {
        Widget widget = widgetRepository.findById(widgetId).orElseThrow();
        model.addAttribute("widget", widget);
        model.addAttribute("widgets", widgetRepository.findAll());
        return "admin/widget";
    }

}