package com.redCoach.repository;

import com.redCoach.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, UUID> {

    Optional<UserRegistration> findByUserNameOrEmail(String userName, String email);
    Optional<UserRegistration> findByUserName(String userName);
    Optional<UserRegistration> findByEmail(String email);
    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
}