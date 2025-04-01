package com.routeX.RoutexProjectAuthService.controller;

import com.routeX.RoutexProjectAuthService.dto.PassengerDto;
import com.routeX.RoutexProjectAuthService.dto.PassengerSignUpRequestDto;
import com.routeX.RoutexProjectAuthService.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    public AuthController(AuthService authService){
        this.authService=authService;
    }
    @PostMapping("/signup/passenger")
    public ResponseEntity<PassengerDto> signUp(@RequestBody PassengerSignUpRequestDto passengerSignupRequestDto) {
        PassengerDto response = authService.signUpPassenger(passengerSignupRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
