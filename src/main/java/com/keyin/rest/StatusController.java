package com.keyin.rest;

import com.keyin.domain.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/flight_ops/status")
    public Status getDefaultStatus() {
        return new Status("no-status");
    }
}
