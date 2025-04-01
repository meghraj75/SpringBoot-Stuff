package com.routex.reviewservice.service;

import com.routex.reviewservice.model.Review;
import com.routex.reviewservice.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.FetchNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepository reviewRepository;
public ReviewServiceImpl(ReviewRepository reviewRepository){
    this.reviewRepository=reviewRepository;
}

    @Override
    public Optional<Review> findByReviewById(Long id) throws EntityNotFoundException {

    Optional<Review>review=this.reviewRepository.findById(id);
    try {
        if (review.isEmpty()) {
            throw new EntityNotFoundException("Review with id " + id + " not found");
        }
    }catch (Exception e){
        e.printStackTrace();
        //e.getClass() == EntityNotFoundException.class only returns true if the exact class matches.
        if(e.getClass()== EntityNotFoundException.class){
            throw new FetchNotFoundException("Review with id " + id + " not found", id);
        }
        throw new FetchNotFoundException("Unable to fetch, PLease try again later!", id);

    }
 return review;
    }

    @Override
    public List<Review> findAllReview() {
        return  this.reviewRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
    try
    {
        Review review=this.reviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        this.reviewRepository.delete(review);
        return true;
    }
    catch (Exception e){
        return false;
    }
    }

    @Override
    @Transactional
    public Review publishReview(Review review) {
       return this.reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, Review newReviewData) {
        Review review=this.reviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if(newReviewData.getRating() != null){
            review.setRating(newReviewData.getRating());
        }
        if(newReviewData.getContent() != null){
            review.setContent(newReviewData.getContent());
        }
        return this.reviewRepository.save(review);


    }
}
