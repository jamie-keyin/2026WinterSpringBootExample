package com.keyin.rest.gate;

import com.keyin.rest.airport.Airport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class GateServiceTest {

    @Mock
    private GateRepository gateRepository;

    @InjectMocks
    private GateService gateService;

    @Test
    public void testCreateGate() {
        Gate gate = new Gate();
        gate.setGateNumber("G1");

        Mockito.when(gateRepository.save(gate)).thenReturn(gate);

        Gate result = gateService.createGate(gate);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("G1", result.getGateNumber());
    }

    @Test
    public void testGetGatesByAirport() {
        Gate gate = new Gate();
        gate.setGateNumber("G1");

        Mockito.when(gateRepository.findByAirportId(1L)).thenReturn(List.of(gate));

        List<Gate> result = gateService.getGatesByAirport(1L);

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("G1", result.get(0).getGateNumber());
    }
}
