package com.routeX.ReviewService.repository;

import com.routeX.ReviewService.model.Review;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Id> {

}
