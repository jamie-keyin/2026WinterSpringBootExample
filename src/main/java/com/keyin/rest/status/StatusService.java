package com.keyin.rest.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public Status getDefaultStatus() {
        return statusRepository.findById((long)1).orElse(null);
    }
}
