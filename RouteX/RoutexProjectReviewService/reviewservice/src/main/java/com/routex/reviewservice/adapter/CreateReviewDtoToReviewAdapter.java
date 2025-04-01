package com.routex.reviewservice.adapter;

import com.routex.reviewservice.dtos.CreateReviewDto;
import com.routex.reviewservice.model.Review;

public interface CreateReviewDtoToReviewAdapter {
    public Review convertDto(CreateReviewDto createReviewDto);
}
