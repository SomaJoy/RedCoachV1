package com.redCoach.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BusDto {

    private Long id;
    private String busNo;
    private String totalSeats;
    private String route;

}
