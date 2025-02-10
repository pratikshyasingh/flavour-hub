package edu.rims.flavour_hub.entity;

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
    private String orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private int orderQuantity;
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.PENDING;
}