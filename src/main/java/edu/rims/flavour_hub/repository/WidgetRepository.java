package edu.rims.flavour_hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.flavour_hub.entity.Widget;

public interface WidgetRepository extends JpaRepository<Widget, String> {

}