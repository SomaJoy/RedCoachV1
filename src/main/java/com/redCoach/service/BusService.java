package com.redCoach.service;

import com.redCoach.entity.Bus;
import com.redCoach.payload.BusDto;

public interface BusService {

    Bus addBus(BusDto busDto);
}
