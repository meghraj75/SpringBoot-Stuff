package com.routeX.ReviewService.service;

import com.routeX.ReviewService.model.Booking;
import com.routeX.ReviewService.model.Review;
import com.routeX.ReviewService.repository.BookingRepository;
import com.routeX.ReviewService.repository.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }

    @Autowired
   private BookingRepository bookingRepository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("*******");
        Review r= Review.builder()
                .content("amazing ride quality")
                .rating(5.0)
                .build();
        System.out.println(r);
        Booking b= Booking.builder().startTime(new Date()).build();

       // reviewRepository.save(r);
        bookingRepository.save(b);

    }
}


