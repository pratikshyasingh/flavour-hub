package edu.rims.flavour_hub.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private String foodId;
    private String foodName;
    private String foodDescription;
    private double price;
    private String foodItemStatus;
    private String foodItemImageUrl;
    private CategoryResponse category;

    @Getter
    @Setter
    public class CategoryResponse {
        private String categoryId;
        private String categoryName;

    }

}
