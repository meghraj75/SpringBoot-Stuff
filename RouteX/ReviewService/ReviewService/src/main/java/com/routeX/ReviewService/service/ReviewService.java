package com.routeX.ReviewService.service;

import com.routeX.ReviewService.model.Review;
import com.routeX.ReviewService.repository.ReviewRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("*******");
        Review r= Review.builder()
                .content("amazing ride quality")

                .rating(5.0).build();

        System.out.println(r);
        reviewRepository.save(r);
    }
}
