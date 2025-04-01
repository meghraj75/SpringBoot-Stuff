package com.routeX.RoutexProjectAuthService.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//used to accept input from the user when signing up.
public class PassengerSignUpRequestDto {

    private String email_id;

    private String password;

    private String phone_no;

    private String name;


}


//why need getter and setter for dto bcz a lib serialization and deserlization convert json in java obj and out dto came in json format