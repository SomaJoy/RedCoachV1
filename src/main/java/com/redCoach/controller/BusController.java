package com.redCoach.controller;

import com.redCoach.entity.Bus;
import com.redCoach.payload.BusDto;
import com.redCoach.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping("/addBus")
    public ResponseEntity<String> addBus(@RequestBody BusDto busDto) {
        Bus bus = busService.addBus(busDto);
        return new ResponseEntity<>("Bus detail added.", HttpStatus.OK);
    }
}

