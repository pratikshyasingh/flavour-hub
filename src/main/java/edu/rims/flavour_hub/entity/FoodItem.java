package edu.rims.flavour_hub.entity;

import edu.rims.flavour_hub.constant.FoodStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "food_item")
@Getter
@Setter
public class FoodItem extends Auditable {

    @Id
    @Column(name = "food_id", length = 255, nullable = false)
    private String foodId;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "food_name", length = 100)
    private String foodName;

    @Column(name = "food_description", columnDefinition = "TEXT")
    private String foodDescription;

    @Column(name = "price", nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "food_item_status", nullable = false)
    private FoodStatus foodItemStatus = FoodStatus.AVAILABLE;
}