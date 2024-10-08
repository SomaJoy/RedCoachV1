package com.redCoach.repository;

import com.redCoach.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {

    Boolean existsByBusNo(String busNo);
}