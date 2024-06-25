package com.redCoach.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "buses")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "bus_no", nullable = false, unique = true)
    private String busNo;

    @Column(name = "total_seats", nullable = false)
    private Integer totalSeats;

    @Column(name = "route", nullable = false)
    private String route;

}
