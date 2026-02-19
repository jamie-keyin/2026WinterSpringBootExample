package com.keyin.rest.status;

import com.keyin.rest.aircraft.Aircraft;
import com.keyin.rest.aircraft.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private AircraftRepository aircraftRepository;

    public Status getDefaultStatus() {
        return statusRepository.findById((long)1).orElse(null);
    }

    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }

    public List<Status> getAllStatuses() {
        return (List<Status>) statusRepository.findAll();
    }

    public Status findStatusById(long id) {
        return statusRepository.findById(id).orElse(null);
    }

    public void deleteStatusById(long id) {
        Status statusFound = statusRepository.findById(id).orElse(null);

        if (statusFound != null) {
            statusRepository.delete(statusFound);
        }
    }

    public Status findStatusByTailNumber(String tailNumber) {
        Aircraft aircraft = aircraftRepository.findByTailNumber(tailNumber);

        if (aircraft != null) {
            return aircraft.getStatus();
        }

        return getDefaultStatus();
    }

}
