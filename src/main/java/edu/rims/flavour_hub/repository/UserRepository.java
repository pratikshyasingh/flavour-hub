package edu.rims.flavour_hub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.flavour_hub.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserEmail(String email);

}
