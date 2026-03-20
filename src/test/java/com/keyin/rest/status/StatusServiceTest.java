package com.keyin.rest.status;

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
}
