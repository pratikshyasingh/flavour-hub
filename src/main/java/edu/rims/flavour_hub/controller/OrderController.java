package edu.rims.flavour_hub.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.rims.flavour_hub.constant.OrderStatus;
import edu.rims.flavour_hub.entity.Order;
import edu.rims.flavour_hub.repository.OrderRepository;

@Controller
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/customer/orderhistory")
    String customerOrderhistory(Principal principal, Model model) {
        List<Order> orders = orderRepository
                .findByUserUserEmailAndOrderStatusNot(principal.getName(), OrderStatus.CART);
        model.addAttribute("orders", orders);
        return "/customer/orderhistory";
    }

}
