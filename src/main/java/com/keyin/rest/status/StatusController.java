package com.keyin.rest.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping("/flight_ops/status")
    public Status getDefaultStatus() {
        return statusService.getDefaultStatus();
    }
}
