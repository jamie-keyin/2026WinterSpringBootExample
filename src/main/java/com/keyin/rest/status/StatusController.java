package com.keyin.rest.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping("/flight_ops/status")
    public List<Status> getDefaultStatus() {
        return statusService.getAllStatuses();
    }

    @GetMapping("/flight_ops/status/{id}")
    public Status getDefaultStatus(@PathVariable long id) {
        return statusService.findStatusById(id);
    }

    @GetMapping("/flight_ops/status_search")
    public Status findStatusByTailNumber(@RequestParam(value = "tailNumber", required = true)  String tailNumber) {
        return statusService.findStatusByTailNumber(tailNumber);
    }

    @PostMapping("/flight_ops/status")
    public Status createStatus(@RequestBody Status status) {
        return statusService.createStatus(status);
    }

    public void deleteStatus(@PathVariable long id) {
        statusService.deleteStatusById(id);
    }
}
