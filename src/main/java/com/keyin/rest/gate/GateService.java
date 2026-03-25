package com.keyin.rest.gate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GateService {
    @Autowired
    private GateRepository gateRepository;

    public Gate createGate(Gate gate) {
        return gateRepository.save(gate);
    }

    public List<Gate> getAllGates() {
        return (List<Gate>) gateRepository.findAll();
    }

    public List<Gate> getGatesByAirport(Long airportId) {
        return gateRepository.findByAirportId(airportId);
    }
}
