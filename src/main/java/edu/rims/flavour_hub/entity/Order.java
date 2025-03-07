package edu.rims.flavour_hub.entity;

import java.util.ArrayList;
import java.util.List;

import edu.rims.flavour_hub.constant.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders") // Avoid conflict with SQL keyword "order"
@Getter
@Setter
public class Order extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private int orderQuantity;
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.CART;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public void addOrderItem(OrderItem orderItem) {
        if (orderItems == null) {
            orderItems = new ArrayList<>();
        }
        orderItem.setOrder(this);
        orderItems.add(orderItem);
        updateDetails();
    }

    private void updateDetails() {
        int totalQuantity = 0;
        double totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalQuantity += orderItem.getOrderItemQuantity();
            totalPrice += orderItem.getOrderItemPrice();
        }
        this.totalPrice = totalPrice;
        orderQuantity = totalQuantity;
    }
}