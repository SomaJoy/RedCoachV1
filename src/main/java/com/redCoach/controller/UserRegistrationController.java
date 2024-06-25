package com.redCoach.controller;

import com.redCoach.entity.UserRegistration;
import com.redCoach.payload.JWTResponse;
import com.redCoach.payload.LoginDto;
import com.redCoach.payload.UserRegistrationDto;
import com.redCoach.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping("/addUser")
    public ResponseEntity<String> createUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        UserRegistration userRegistration = userRegistrationService.createUser(userRegistrationDto);
        if (userRegistration != null) {
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("User registration failed", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginDto loginDto) {
        String jwtToken = userRegistrationService.verifyLogin(loginDto);
        if (jwtToken != null) {
            JWTResponse jwtResponse = new JWTResponse();
            jwtResponse.setToken(jwtToken);
            return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
    }
}
