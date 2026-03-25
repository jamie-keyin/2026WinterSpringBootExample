package com.keyin.rest.gate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gates")
@CrossOrigin
public class GateController {
    @Autowired
    private GateService gateService;

    @PostMapping
    public Gate createGate(@RequestBody Gate gate) {
        return gateService.createGate(gate);
    }

    @GetMapping
    public List<Gate> getAllGates() {
        return gateService.getAllGates();
    }

    @GetMapping("/airport/{airportId}")
    public List<Gate> getGatesByAirport(@PathVariable Long airportId) {
        return gateService.getGatesByAirport(airportId);
    }
}
