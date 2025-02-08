package com.routeX.ReviewService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Passenger extends BaseModel{

    private String name;
    @OneToMany(mappedBy = "passenger") //one passenger has many booking
    private List<Booking> booking=new ArrayList<>();
}
