package com.keyin.rest.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AircraftController {
    @Autowired
    private AircraftService aircraftService;

    @PostMapping("/flight_ops/aircraft")
    public Aircraft createAircraft(@RequestBody Aircraft aircraft) {
        return aircraftService.createAircraft(aircraft);
    }

    @GetMapping("/flight_ops/aircraft_by_status")
    public List<Aircraft> getByStatus(@RequestParam(value = "status", required = false)  String status) {
        return aircraftService.getAllAircraftForStatus(status);
    }
}
