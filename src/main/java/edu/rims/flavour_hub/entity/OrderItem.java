package edu.rims.flavour_hub.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@Getter
@Setter
public class OrderItem extends Auditable {

    @Id
    @Column(name = "order_item_id", length = 255, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private FoodItem foodItem;

    @Column(name = "order_item_quantity", nullable = false)
    @Setter(AccessLevel.NONE)
    private int orderItemQuantity;

    @Column(name = "order_item_price", nullable = false)
    @Setter(AccessLevel.NONE)
    private double orderItemPrice;

    public OrderItem() {

    }

    public OrderItem(FoodItem foodItem) {
        this.foodItem = foodItem;
        orderItemQuantity = 1;
        orderItemPrice = foodItem.getPrice();
    }

    public void incrementQuantity() {
        orderItemQuantity += 1;
        orderItemPrice = foodItem.getPrice() * orderItemQuantity;
    }

    public void decrementQuantity() {
        orderItemQuantity -= 1;
        orderItemPrice = foodItem.getPrice() * orderItemQuantity;
    }
}
