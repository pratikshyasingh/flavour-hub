package edu.rims.flavour_hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.rims.flavour_hub.entity.FoodItem;

public interface Food_itemRepository extends JpaRepository<FoodItem, String> {

}