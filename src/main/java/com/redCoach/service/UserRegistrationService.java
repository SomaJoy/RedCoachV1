package com.redCoach.service;


import com.redCoach.entity.UserRegistration;
import com.redCoach.payload.LoginDto;
import com.redCoach.payload.UserRegistrationDto;

public interface UserRegistrationService {

    UserRegistration createUser(UserRegistrationDto userRegistrationDto);

    String verifyLogin(LoginDto loginDto);
}
