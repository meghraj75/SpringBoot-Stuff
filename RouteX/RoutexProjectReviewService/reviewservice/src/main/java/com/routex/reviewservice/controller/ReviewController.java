package com.routex.reviewservice.controller;

import com.routex.reviewservice.adapter.CreateReviewDtoToReviewAdapter;
import com.routex.reviewservice.adapter.CreateReviewDtoToReviewAdapterImpl;
import com.routex.reviewservice.dtos.CreateReviewDto;
import com.routex.reviewservice.dtos.ReviewDto;
import com.routex.reviewservice.model.Review;
import com.routex.reviewservice.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private ReviewService reviewService;
   private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;
    public ReviewController(ReviewService reviewService, CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter){
        this.reviewService=reviewService;
        this.createReviewDtoToReviewAdapter=createReviewDtoToReviewAdapter;
    }

    @PostMapping
    public ResponseEntity<?> publishReview(@Validated @RequestBody CreateReviewDto request){
        log.info("Received request: {}", request);
        Review incomingReview=this.createReviewDtoToReviewAdapter.convertDto(request);
        log.info("Converted review: {}", incomingReview);
        if(incomingReview == null){
            log.error("Review conversion failed, returning bad request.");
            return  new ResponseEntity<>("invalid args",HttpStatus.BAD_REQUEST);
        }
        Review review=this.reviewService.publishReview(incomingReview);
        ReviewDto response=ReviewDto.builder()
                        .id(review.getId())
                                .content(review.getContent())
                                        .booking(review.getBooking().getId())
                                                .rating(review.getRating())
                                                        .createdAt(review.getCreatedAt())
                                                                .updatedAt(review.getUpdatedAt())
                                                                       .build();
        return  new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Review> >getAllReview(){
        List<Review>reviews=this.reviewService.findAllReview();
        return new ResponseEntity<>(reviews,HttpStatus.OK);
    }


    @GetMapping("/{reviewId}")
    public ResponseEntity<?>findReviewById(@PathVariable Long reviewId){
        try {
            Optional<Review>review=this.reviewService.findByReviewById(reviewId);
            return new ResponseEntity<>(review, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?>deleteReviewById(@PathVariable Long reviewId){
        try{
            boolean isDeleted=this.reviewService.deleteById(reviewId);
            if(!isDeleted)return  new ResponseEntity<>("Unable to delete Review", HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<?>updateReviewBYId(@PathVariable Long reviewId,Review request){
        try{
            Review review=this.reviewService.updateReview(reviewId,request);
            return new ResponseEntity<>(review,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
