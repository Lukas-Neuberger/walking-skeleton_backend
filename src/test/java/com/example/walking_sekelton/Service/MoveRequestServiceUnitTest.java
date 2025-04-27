package com.example.walking_sekelton.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.walking_sekelton.model.MoveRequest;
import com.example.walking_sekelton.repository.MoveRequestRepository;
import com.example.walking_sekelton.service.MoveRequestService;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class MoveRequestServiceUnitTest {

  @Mock private MoveRequestRepository moveRequestRepository;

  @InjectMocks private MoveRequestService moveRequestService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void shouldCreateMoveRequest() {
    MoveRequest moveRequest =
        new MoveRequest(1L, "John Doe", "45 Main St", "123 Main St", LocalDate.now());
    when(moveRequestRepository.save(any(MoveRequest.class))).thenReturn(moveRequest);

    MoveRequest savedRequest = moveRequestService.createMoveRequest(moveRequest);
    assertNotNull(savedRequest);
    assertEquals("John Doe", savedRequest.getName());
    verify(moveRequestRepository, times(1)).save(moveRequest);
  }

  @Test
  void shouldReturnAllMoveRequests() {
    List<MoveRequest> moveRequests =
        Arrays.asList(
            new MoveRequest(1L, "John Doe", "45 Main St", "123 Main St", LocalDate.now()),
            new MoveRequest(2L, "Jane Doe", "10 Main St", "50 Main St", LocalDate.now()));
    when(moveRequestRepository.findAll()).thenReturn(moveRequests);

    List<MoveRequest> result = moveRequestService.getAllMoveRequests();
    assertEquals(2, result.size());
    verify(moveRequestRepository, times(1)).findAll();
  }
}
