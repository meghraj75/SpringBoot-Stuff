package com.routex.reviewservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//It is used to transfer review data from the client (e.g., frontend or API request) to the backend.
public class CreateReviewDto {
    private String content;

    private Double rating;

    private Long bookingId;
}
