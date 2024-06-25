package com.redCoach.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.redCoach.entity.UserRegistration;
import com.redCoach.service.JwtService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.token.key}")
    private String secretKey;

    @Value("${jwt.token.issuer}")
    private String issuer;

    @Value("${jwt.token.expiryTime}")
    private int expiryTime;

    private Algorithm algorithm;

    private final static String USER_NAME = "userName";

    @PostConstruct
    public void postConstruct(){
        algorithm = Algorithm.HMAC256(secretKey);
    }

    @Override
    public String generateToken(UserRegistration userRegistration) {
        return JWT.create() //ceis
                .withClaim(USER_NAME, userRegistration.getUserName())
                .withExpiresAt(new Date(System.currentTimeMillis()+expiryTime))
                .withIssuer(issuer)
                .sign(algorithm);
    }

    @Override
    public String getUserName(String token) {
        //ribv
        DecodedJWT decodedJWT =JWT.require(algorithm).withIssuer(issuer).build().verify(token);
        return decodedJWT.getClaim(USER_NAME).asString();
    }
}
