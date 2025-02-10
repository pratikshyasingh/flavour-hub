package edu.rims.flavour_hub.entity;

import edu.rims.flavour_hub.constant.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter

public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false, length = 255)
    private String userName;

    @Column(nullable = false, length = 100, unique = true)
    private String userEmail;

    @Column(nullable = false, length = 30, unique = true)
    private String userPhone;

    @Column(nullable = false, length = 255)
    private String userPassword;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String userAddress;

    @Column(columnDefinition = "TEXT")
    private String userImageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole = UserRole.CUSTOMER;
}
