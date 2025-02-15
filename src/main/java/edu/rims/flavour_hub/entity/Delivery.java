package edu.rims.flavour_hub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import edu.rims.flavour_hub.constant.DeliveryStatus;

@Entity
@Table(name = "delivery")
@Setter
@Getter
public class Delivery extends Auditable {

    @Id
    @Column(name = "delivery_id", length = 255, nullable = false)
    private String deliveryId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "delivery_address", columnDefinition = "TEXT")
    private String deliveryAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_status", nullable = false)
    private DeliveryStatus deliveryStatus = DeliveryStatus.PENDING;
}
