package com.keyin.rest.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public List<Airport> getAllAirports() {
        return (List<Airport>) airportRepository.findAll();
    }

    public Airport findAirportById(long id) {
        return airportRepository.findById(id).orElse(null);
    }

    public Airport findAirportByCode(String code) {
        return airportRepository.findByCode(code);
    }
}
