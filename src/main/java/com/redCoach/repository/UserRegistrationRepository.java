package com.redCoach.repository;

import com.redCoach.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, UUID> {

    Optional<UserRegistration> findByUserName(String userName);
}