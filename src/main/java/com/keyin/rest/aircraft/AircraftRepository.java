package com.keyin.rest.aircraft;

import com.keyin.rest.status.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends CrudRepository<Aircraft, Long> {
    public List<Aircraft> findByStatus_Status(String status);

    public Aircraft findByTailNumber(String tailNumber);
}
