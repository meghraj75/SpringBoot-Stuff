package com.routex.reviewservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

public class Passenger extends Basemodel{

    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "passenger",fetch = FetchType.LAZY) //one passenger has many booking
    private List<Booking> booking=new ArrayList<>();
}

