package edu.rims.flavour_hub.entity;

import java.util.List;

import edu.rims.flavour_hub.constant.FoodStatus;
import jakarta.persistence.*;

import lombok.Setter;

import lombok.Getter;

@Entity
@Table(name = "category")
@Setter
@Getter
public class Category extends Auditable {

    @Id
    @Column(name = "category_id", length = 255, nullable = false)
    private String categoryId;

    @Column(name = "category_name", nullable = false, length = 100)
    private String categoryName;

    @Column(name = "category_description", columnDefinition = "TEXT")
    private String categoryDescription;

    @Column(name = "category_image_url", length = 250)
    private String categoryImageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "food_status", nullable = false)
    private FoodStatus foodStatus = FoodStatus.AVAILABLE;

    @OneToMany(mappedBy = "category")
    private List<FoodItem> foodItems;

}
