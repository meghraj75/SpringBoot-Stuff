package com.routeX.RoutexProjectAuthService.dto;

import com.routeX.RoutexProjectAuthService.model.Passenger;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//used to return passenger details as a response
public class PassengerDto {

    private String id;

    private String name;

    private String email_id;

    private String password;

    private String phone_no;

    private Date createdAt;

    //is a factory method that converts a Passenger entity into a PassengerDto
    public static PassengerDto from(Passenger p) {
        return PassengerDto.builder()
                .id(p.getId().toString())
                .createdAt(p.getCreatedAt())
                .email_id(p.getEmail_id())
                .password(p.getPassword())
                .phone_no(p.getPhone_no())
                .name(p.getName())
                .build();
    }
}
