package edu.rims.flavour_hub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart")
@Getter
@Setter
public class Cart extends Auditable {

    @Id
    @Column(name = "cart_id", length = 255, nullable = false)
    private String cartId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "food_id", length = 255, nullable = false)
    private String foodId;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}
