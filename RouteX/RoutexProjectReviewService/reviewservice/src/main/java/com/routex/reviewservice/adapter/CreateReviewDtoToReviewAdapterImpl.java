package com.routex.reviewservice.adapter;

import com.routex.reviewservice.dtos.CreateReviewDto;
import com.routex.reviewservice.model.Booking;
import com.routex.reviewservice.model.Review;
import com.routex.reviewservice.repository.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Slf4j
@Component
public class CreateReviewDtoToReviewAdapterImpl implements CreateReviewDtoToReviewAdapter{
    private BookingRepository bookingRepository;

    public CreateReviewDtoToReviewAdapterImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    @Override
    public Review convertDto(CreateReviewDto createReviewDto) {
        if (createReviewDto == null) {
            log.error("CreateReviewDto is null");
            return null;
        }

        log.info("Fetching booking with ID: {}", createReviewDto.getBookingId());
        Optional<Booking> booking = bookingRepository.findById(createReviewDto.getBookingId());

        if (booking.isEmpty()) {
            log.error("Booking not found for ID: {}", createReviewDto.getBookingId());
            return null;  // This is causing the "invalid args" response
        }

        Review review = Review.builder()
                .rating(createReviewDto.getRating())
                .booking(booking.get())
                .content(createReviewDto.getContent())
                .build();

        log.info("Successfully converted Review: {}", review);
        return review;
    }

}
