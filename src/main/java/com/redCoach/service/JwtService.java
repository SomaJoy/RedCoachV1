package com.redCoach.service;

import com.redCoach.entity.UserRegistration;

public interface JwtService {
    public String generateToken(UserRegistration userRegistration);
    public String getUserName(String token);
}
