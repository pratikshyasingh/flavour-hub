package edu.rims.flavour_hub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import edu.rims.flavour_hub.constant.WidgetStatus;

@Entity
@Table(name = "widget")
@Getter
@Setter
public class Widget extends Auditable {

    @Id
    @Column(name = "widget_id", length = 255, nullable = false)
    private String widgetId;

    @Column(name = "widget_name", length = 100, nullable = false)
    private String widgetName;

    @Enumerated(EnumType.STRING)
    @Column(name = "widget_status", columnDefinition = "ENUM('AVAILABLE','UNAVAILABLE') DEFAULT 'AVAILABLE'")
    private WidgetStatus widgetStatus = WidgetStatus.AVAILABLE;

    @ManyToMany
    @JoinTable(name = "widget_product", joinColumns = @JoinColumn(name = "widget_id"), inverseJoinColumns = @JoinColumn(name = "food_id"))
    private List<FoodItem> foodItems;
}
