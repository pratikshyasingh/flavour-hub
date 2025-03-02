package edu.rims.flavour_hub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}
