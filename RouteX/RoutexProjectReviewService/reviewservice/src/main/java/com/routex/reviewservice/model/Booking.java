package com.routex.reviewservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class Booking extends Basemodel{


    @Enumerated(EnumType.STRING) // say that enum store in db in string format if it oridinal then number
    private BookingStatus bookingStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    private Long totDistance;

    @ManyToOne(fetch = FetchType.LAZY) // many bookings can have a single driver.
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)  //many bookings can be associated with a single passenger.
    private Passenger passenger;
}


