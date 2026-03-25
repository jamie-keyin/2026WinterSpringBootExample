package com.keyin.rest.status;

import com.keyin.rest.aircraft.Aircraft;
import com.keyin.rest.aircraft.AircraftRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StatusServiceTest {

    @Mock
    private StatusRepository statusRepository;

    @Mock
    private AircraftRepository aircraftRepository;

    @InjectMocks
    private StatusService statusService;

    @Test
    public void testFindStatusById() {
        Status status = new Status();
        status.setId(1L);
        status.setStatus("Active");

        Mockito.when(statusRepository.findById(1L)).thenReturn(Optional.of(status));

        Status result = statusService.findStatusById(1L);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1L, result.getId());
        Assertions.assertEquals("Active", result.getStatus());
    }

    @Test
    public void testFindStatusByIdNotFound() {
        Mockito.when(statusRepository.findById(1L)).thenReturn(Optional.empty());

        Status result = statusService.findStatusById(1L);

        Assertions.assertNull(result);
    }

    @Test
    public void testGetAllStatuses() {
        Status status = new Status();
        status.setId(1L);
        status.setStatus("Active");

        Mockito.when(statusRepository.findAll()).thenReturn(java.util.List.of(status));

        java.util.List<Status> results = statusService.getAllStatuses();

        Assertions.assertNotNull(results);
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals("Active", results.get(0).getStatus());
    }

    @Test
    public void testCreateStatus() {
        Status status = new Status();
        status.setStatus("New Status");

        Mockito.when(statusRepository.save(status)).thenReturn(status);

        Status result = statusService.createStatus(status);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("New Status", result.getStatus());
        Mockito.verify(statusRepository, Mockito.times(1)).save(status);
    }

    @Test
    public void testDeleteStatusById() {
        Status status = new Status();
        status.setId(1L);

        Mockito.when(statusRepository.findById(1L)).thenReturn(Optional.of(status));

        statusService.deleteStatusById(1L);

        Mockito.verify(statusRepository, Mockito.times(1)).delete(status);
    }

    @Test
    public void testFindStatusByTailNumber() {
        String tailNumber = "N12345";
        Status status = new Status();
        status.setStatus("In Flight");
        
        Aircraft aircraft = new Aircraft();
        aircraft.setTailNumber(tailNumber);
        aircraft.setStatus(status);

        Mockito.when(aircraftRepository.findByTailNumber(tailNumber)).thenReturn(aircraft);

        Status result = statusService.findStatusByTailNumber(tailNumber);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("In Flight", result.getStatus());
    }

    @Test
    public void testFindStatusByTailNumberNotFound() {
        String tailNumber = "UNKNOWN";
        Status defaultStatus = new Status();
        defaultStatus.setId(1L);
        defaultStatus.setStatus("Default");

        Mockito.when(aircraftRepository.findByTailNumber(tailNumber)).thenReturn(null);
        Mockito.when(statusRepository.findById(1L)).thenReturn(Optional.of(defaultStatus));

        Status result = statusService.findStatusByTailNumber(tailNumber);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Default", result.getStatus());
    }
}
