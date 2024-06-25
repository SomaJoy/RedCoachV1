package com.redCoach.service.impl;

import com.redCoach.entity.UserRegistration;
import com.redCoach.payload.LoginDto;
import com.redCoach.payload.UserRegistrationDto;
import com.redCoach.repository.UserRegistrationRepository;
import com.redCoach.service.JwtService;
import com.redCoach.service.UserRegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserRegistration createUser(UserRegistrationDto userRegistrationDto) {
        UserRegistration userRegistration = mapToUserRegistration(userRegistrationDto);
        userRegistration.setPassword(BCrypt.hashpw(userRegistrationDto.getPassword(), BCrypt.gensalt(4)));
        UserRegistration saveUser = userRegistrationRepository.save(userRegistration);
        return saveUser;
    }

    @Override
    public String verifyLogin(LoginDto loginDto) {
        Optional<UserRegistration> opUser = userRegistrationRepository.findByUserName(loginDto.getUserName());
        if(opUser.isPresent()){
            UserRegistration userRegistration = opUser.get();
            if(BCrypt.checkpw(loginDto.getPassword(), userRegistration.getPassword())){
                return jwtService.generateToken(userRegistration);
            }
        }
        return null;
    }

    public UserRegistration mapToUserRegistration(UserRegistrationDto userRegistrationDto){
        UserRegistration userRegistration = modelMapper.map(userRegistrationDto, UserRegistration.class);
        return userRegistration;
    }
    public UserRegistrationDto mapToUserRegistrationDto(UserRegistration userRegistration){
        UserRegistrationDto userRegistrationDto = modelMapper.map(userRegistration, UserRegistrationDto.class);
        return userRegistrationDto;
    }
}
