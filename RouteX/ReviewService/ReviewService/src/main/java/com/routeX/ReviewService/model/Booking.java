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
}


//Cascade Type	Description
//PERSIST	Saves child entities when the parent is saved.
//MERGE	Updates child entities when the parent is updated.
//REMOVE	Deletes child entities when the parent is deleted.
//REFRESH	Reloads child entities when the parent is refreshed.
//DETACH	Detaches child entities when the parent is detached.
//ALL	Applies all of the above operations.