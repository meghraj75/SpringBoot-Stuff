package com.routeX.ReviewService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PathVariable;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "driver_id")//pk of driver table
public class DriverReview extends Review{
    private String driverReviewcmt;
}
