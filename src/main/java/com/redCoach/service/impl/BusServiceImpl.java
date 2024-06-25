package com.redCoach.service.impl;

import com.redCoach.entity.Bus;
import com.redCoach.payload.BusDto;
import com.redCoach.repository.BusRepository;
import com.redCoach.service.BusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BusRepository busRepository;

    @Override
    public Bus addBus(BusDto busDto) {
        Bus bus = mapToEntity(busDto);
        Bus saveBus = busRepository.save(bus);
        return saveBus;
    }

    public BusDto mapToDto(Bus bus){
        BusDto busDto = modelMapper.map(bus, BusDto.class);
        return busDto;
    }
    public Bus mapToEntity(BusDto busDto){
        Bus bus = modelMapper.map(busDto, Bus.class);
        return bus;
    }
}
