package edu.rims.flavour_hub.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.flavour_hub.constant.OrderStatus;
import edu.rims.flavour_hub.entity.FoodItem;
import edu.rims.flavour_hub.entity.Order;
import edu.rims.flavour_hub.entity.OrderItem;
import edu.rims.flavour_hub.entity.User;
import edu.rims.flavour_hub.repository.Food_itemRepository;
import edu.rims.flavour_hub.repository.OrderRepository;
import edu.rims.flavour_hub.repository.UserRepository;
import edu.rims.flavour_hub.service.UserService;

@Controller
public class CartController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private Food_itemRepository food_itemRepository;

    @GetMapping("/customer/cart/cart")
    String customerCart() {
        return "customer/cart";
    }

    @GetMapping("/customer/cart")
    String customerCart(@RequestParam("item") String itemId, Principal principal) {
        String username = principal.getName();
        User user = userService.getUser(username);
        Order order = orderRepository
                .findByUserUserIdAndOrderStatus(user.getUserId(), OrderStatus.CART).orElse(new Order());
        order.setUser(user);
        FoodItem foodItem = food_itemRepository.findById(itemId).orElseThrow();

        OrderItem orderItem = new OrderItem(foodItem);
        order.addOrderItem(orderItem);
        orderRepository.save(order);
        return "customer/cart";
    }

    @GetMapping("/customer/placeOrder")
    String customerPlaceOrder() {
        return "customer/placeOrder";
    }

}
