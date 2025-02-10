package edu.rims.flavour_hub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review_and_rating")
@Getter
@Setter

public class ReviewAndRating extends Auditable {

    @Id
    @Column(name = "review_id", nullable = false, length = 255)
    private String reviewId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private FoodItem foodItem;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "review_text", columnDefinition = "TEXT")
    private String reviewText;
}
