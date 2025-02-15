package edu.rims.flavour_hub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "food_category_mapping")
@Setter
@Getter
public class FoodCategoryMapping extends Auditable {

    @Id
    @Column(name = "food_category_mapping_id", length = 255)
    private String foodCategoryMappingId;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private FoodItem foodItem;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
