package edu.rims.flavour_hub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.rims.flavour_hub.constant.FoodStatus;
import edu.rims.flavour_hub.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
    @Query("SELECT c FROM Category c JOIN c.foodItems f WHERE c.id = :id AND f.foodItemStatus = :status")
    Optional<Category> findCategoryByIdAndFoodItemStatus(@Param("id") String id, @Param("status") FoodStatus status);

}
