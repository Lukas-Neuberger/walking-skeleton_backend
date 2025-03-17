package com.example.walking_sekelton.Controller;

import com.example.walking_sekelton.controller.MoveRequestController;
import com.example.walking_sekelton.model.MoveRequest;
import com.example.walking_sekelton.service.MoveRequestService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MoveRequestControllerUnitTest {

    @Mock
    private MoveRequestService moveRequestService;

    @InjectMocks
    private MoveRequestController moveRequestController;

    @Test
    void createMoveRequest_shouldReturnCreated() {
        MoveRequest moveRequest = new MoveRequest(1, "Bob Baumeister", "Mühlgasse 45", "Mühlgasse 342", LocalDate.parse("2025-07-31"));

        when(moveRequestService.createMoveRequest(any(MoveRequest.class))).thenReturn(moveRequest);

        ResponseEntity<MoveRequest> response = moveRequestController.createMoveRequest(moveRequest);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo(moveRequest);

        verify(moveRequestService, times(1)).createMoveRequest(any(MoveRequest.class));
    }

    @Test
    void getAllMoveRequests_shouldReturnMoveRequestList() {
        MoveRequest request1 = new MoveRequest(1, "Alice", "Street 1", "Street 2", LocalDate.now());
        MoveRequest request2 = new MoveRequest(2, "Bob", "Street 3", "Street 4", LocalDate.now());

        List<MoveRequest> moveRequests = List.of(request1, request2);

        when(moveRequestService.getAllMoveRequests()).thenReturn(moveRequests);

        ResponseEntity<List<MoveRequest>> response = moveRequestController.getAllMoveRequests();

        assertThat(response).isNotNull();
        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody().get(0).getName()).isEqualTo(request1.getName());
        assertThat(response.getBody().get(1).getName()).isEqualTo(request1.getName());

        verify(moveRequestService, times(1)).getAllMoveRequests();
    }
}
