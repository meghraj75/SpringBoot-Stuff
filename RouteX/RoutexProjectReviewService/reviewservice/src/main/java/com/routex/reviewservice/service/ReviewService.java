package com.routex.reviewservice.service;

import com.routex.reviewservice.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReviewService {

    public Optional<Review> findByReviewById(Long id);

    public List<Review> findAllReview();

    public boolean deleteById(Long id);

    public Review publishReview(Review review);

    public Review updateReview(Long id,Review review);


}
