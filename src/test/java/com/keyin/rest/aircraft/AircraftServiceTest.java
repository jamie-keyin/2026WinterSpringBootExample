package com.keyin.rest.aircraft;

import com.keyin.rest.status.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AircraftServiceTest {

    @Mock
    private AircraftRepository aircraftRepository;

    @InjectMocks
    private AircraftService aircraftService;

    @Test
    public void testCreateAircraft() {
        Aircraft aircraft = new Aircraft();
        aircraft.setTailNumber("N12345");

        Mockito.when(aircraftRepository.save(aircraft)).thenReturn(aircraft);

        Aircraft result = aircraftService.createAircraft(aircraft);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("N12345", result.getTailNumber());
    }

    @Test
    public void testGetAllAircraftForStatus() {
        Aircraft aircraft = new Aircraft();
        aircraft.setTailNumber("N12345");
        Status status = new Status();
        status.setStatus("Active");
        aircraft.setStatus(status);

        Mockito.when(aircraftRepository.findByStatus_Status("Active")).thenReturn(List.of(aircraft));

        List<Aircraft> result = aircraftService.getAllAircraftForStatus("Active");

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("N12345", result.get(0).getTailNumber());
    }
}
