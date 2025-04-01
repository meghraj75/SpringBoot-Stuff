package com.routeX.RoutexProjectAuthService.model;

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
@Entity
public class Passenger extends BaseModel{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone_no;

    @Column(nullable = false)
    private String email_id;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "passenger") //one passenger has many booking
    private List<Booking> booking=new ArrayList<>();
}

