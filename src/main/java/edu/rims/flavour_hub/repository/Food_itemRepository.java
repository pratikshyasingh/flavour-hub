package edu.rims.flavour_hub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.flavour_hub.constant.FoodStatus;
import edu.rims.flavour_hub.entity.FoodItem;

public interface Food_itemRepository extends JpaRepository<FoodItem, String> {
    List<FoodItem> findByFoodNameContainingIgnoreCase(String foodName);

    List<FoodItem> findByFoodNameContainingIgnoreCaseAndFoodItemStatus(String foodName, FoodStatus status);
}