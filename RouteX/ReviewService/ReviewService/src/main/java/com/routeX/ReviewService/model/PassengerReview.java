package com.routeX.ReviewService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "passenger_id") // this is primary key of passenger table
public class PassengerReview extends Review{
    private String passengerReviewContent;

}
