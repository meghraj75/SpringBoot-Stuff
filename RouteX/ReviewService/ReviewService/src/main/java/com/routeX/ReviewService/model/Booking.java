package com.routeX.ReviewService.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking extends BaseModel{

    @OneToOne(cascade = CascadeType.REMOVE)
    private Review review;
    @Enumerated(EnumType.STRING) // say that enum store in db in string format if it oridinal then number
    private BookingStatus bookingStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    private Long totDistance;

    @ManyToOne  // many bookings can have a single driver.
    private Driver driver;

    @ManyToOne  //many bookings can be associated with a single passenger.
    private Passenger passenger;
}


