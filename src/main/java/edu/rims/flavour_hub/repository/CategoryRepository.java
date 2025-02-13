package edu.rims.flavour_hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.flavour_hub.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
