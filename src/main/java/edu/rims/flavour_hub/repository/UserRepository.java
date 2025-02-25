package edu.rims.flavour_hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.flavour_hub.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
