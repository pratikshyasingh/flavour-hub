package edu.rims.flavour_hub.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.flavour_hub.constant.WidgetStatus;
import edu.rims.flavour_hub.entity.Widget;

public interface WidgetRepository extends JpaRepository<Widget, String> {
    List<Widget> findByWidgetStatus(WidgetStatus widgetStatus, Sort sort);
}