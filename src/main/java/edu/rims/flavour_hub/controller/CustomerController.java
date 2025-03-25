package edu.rims.flavour_hub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.rims.flavour_hub.constant.WidgetStatus;
import edu.rims.flavour_hub.entity.Category;
import edu.rims.flavour_hub.repository.CategoryRepository;
import edu.rims.flavour_hub.repository.WidgetRepository;

@Controller
public class CustomerController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private WidgetRepository widgetRepository;

    @GetMapping("/customer")
    String customerHome(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("widgets", widgetRepository.findByWidgetStatus(WidgetStatus.AVAILABLE, Sort.by("sequence")));
        return "customer/home";
    }
}
