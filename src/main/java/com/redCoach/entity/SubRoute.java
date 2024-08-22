package com.redCoach.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long routeId;

    @Column(name = "from_location", nullable = false, unique = true)
    private String fromLocation;

    @Column(name = "to_location", nullable = false, unique = true)
    private String toLocation;

    @Column(name = "date", nullable = false)
    private String date;


}
