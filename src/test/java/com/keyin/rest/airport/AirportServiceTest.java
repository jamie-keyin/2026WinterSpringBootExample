package com.keyin.rest.airport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AirportServiceTest {

    @Mock
    private AirportRepository airportRepository;

    @InjectMocks
    private AirportService airportService;

    @Test
    public void testCreateAirport() {
        Airport airport = new Airport();
        airport.setName("St. John's International");
        airport.setCode("YYT");

        Mockito.when(airportRepository.save(airport)).thenReturn(airport);

        Airport result = airportService.createAirport(airport);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("YYT", result.getCode());
        Mockito.verify(airportRepository, Mockito.times(1)).save(airport);
    }

    @Test
    public void testFindAirportByCode() {
        Airport airport = new Airport();
        airport.setCode("YYT");

        Mockito.when(airportRepository.findByCode("YYT")).thenReturn(airport);

        Airport result = airportService.findAirportByCode("YYT");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("YYT", result.getCode());
    }

    @Test
    public void testGetAllAirports() {
        Airport airport = new Airport();
        airport.setCode("YYT");

        Mockito.when(airportRepository.findAll()).thenReturn(List.of(airport));

        List<Airport> result = airportService.getAllAirports();

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("YYT", result.get(0).getCode());
    }
}
