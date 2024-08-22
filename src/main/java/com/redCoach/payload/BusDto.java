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

    private Long busId;
    private String busNo;
    private Integer totalSeats;
    private String route;

}
