package com.routeX.RoutexProjectAuthService.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" , "bookings"})
@Entity
public class Driver extends BaseModel{

    private String dname;

    @Column(nullable = false,unique = true)
    private String dlicences_Number;

    private String phoneNumber;


    @OneToMany(mappedBy = "driver")// driver has many booking
    private List<Booking> booking=new ArrayList<>();

}