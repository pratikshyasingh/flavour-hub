package edu.rims.flavour_hub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.flavour_hub.constant.OrderStatus;
import edu.rims.flavour_hub.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String> {

    Optional<Order> findByUserUserIdAndOrderStatus(int userId, OrderStatus status);

}
