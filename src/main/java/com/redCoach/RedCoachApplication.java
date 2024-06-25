package com.redCoach;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RedCoachApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedCoachApplication.class, args);
	}

	@Bean
    public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
