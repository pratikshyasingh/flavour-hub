package edu.rims.flavour_hub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@Getter
@Setter
public class OrderItem extends Auditable {

    @Id
    @Column(name = "order_item_id", length = 255, nullable = false)
    private String orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private FoodItem foodItem;

    @Column(name = "order_item_quantity", nullable = false)
    private int orderItemQuantity;

    @Column(name = "order_item_price", nullable = false)
    private double orderItemPrice;
}
