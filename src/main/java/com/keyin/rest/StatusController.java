package com.keyin.rest;

import com.keyin.domain.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @Autowired
    private StatusRepository statusRepository;

    @GetMapping("/flight_ops/status")
    public Status getDefaultStatus() {
        return statusRepository.findById((long)1).orElse(null);
    }
}
