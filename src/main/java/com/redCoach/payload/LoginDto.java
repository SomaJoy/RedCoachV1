package com.redCoach.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {

    private String userNameOrEmail;
    private String password;
}
