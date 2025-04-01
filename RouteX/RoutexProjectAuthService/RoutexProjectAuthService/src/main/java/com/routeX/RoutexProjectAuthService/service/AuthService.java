package com.routeX.RoutexProjectAuthService.service;

import com.routeX.RoutexProjectAuthService.dto.PassengerDto;
import com.routeX.RoutexProjectAuthService.dto.PassengerSignUpRequestDto;
import com.routeX.RoutexProjectAuthService.model.Passenger;
import com.routeX.RoutexProjectAuthService.repository.PassengerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private PassengerRepository passengerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public AuthService(PassengerRepository passengerRepository,BCryptPasswordEncoder bCryptPasswordEncoder){
        this.passengerRepository=passengerRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }

//    Converts Request DTO into Entity
//
//    Takes input from PassengerSignUpRequestDto, which contains the sign-up details (like email, name, password, phone number).
//    Converts it into a Passenger entity that will be stored in the database.
//    Saves the Passenger Entity in the Database
//
//    Calls passengerRepository.save(passenger), which persists the Passenger entity into the database.
//    newPassenger now contains all database-generated values (like id, createdAt, etc.).
//    Converts Entity to Response DTO
//
//    Calls PassengerDto.from(newPassenger) to convert the saved Passenger entity into a PassengerDto.
//    This ensures only relevant data is sent back in the response, keeping things secure and structured.
//

    public PassengerDto signUpPassenger(PassengerSignUpRequestDto passengerSignUpRequestDto){
        Passenger passenger= Passenger.builder()
                .email_id(passengerSignUpRequestDto.getEmail_id())
                .name(passengerSignUpRequestDto.getName())
                .password(bCryptPasswordEncoder.encode(passengerSignUpRequestDto.getPassword()))
                .phone_no(passengerSignUpRequestDto.getPhone_no())
                .build();
        Passenger newPassenger=passengerRepository.save(passenger);

        return PassengerDto.from(newPassenger);
    }
}
