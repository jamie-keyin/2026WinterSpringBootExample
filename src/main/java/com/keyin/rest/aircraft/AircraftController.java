package com.keyin.rest.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {
    @Autowired
    private AircraftService aircraftService;

    @PostMapping
    public Aircraft createAircraft(@RequestBody Aircraft aircraft) {
        return aircraftService.createAircraft(aircraft);
    }

    @GetMapping("/by_status")
    public List<Aircraft> getByStatus(@RequestParam(value = "status", required = false)  String status) {
        return aircraftService.getAllAircraftForStatus(status);
    }
}
