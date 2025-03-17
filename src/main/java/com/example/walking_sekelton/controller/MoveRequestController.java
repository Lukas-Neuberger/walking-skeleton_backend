package com.example.walking_sekelton.controller;

import com.example.walking_sekelton.model.MoveRequest;
import com.example.walking_sekelton.service.MoveRequestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/move-requests")
public class MoveRequestController {

    private final MoveRequestService moveRequestService;

    public MoveRequestController(MoveRequestService moveRequestService) {
        this.moveRequestService = moveRequestService;
    }

    @PostMapping
    public ResponseEntity<MoveRequest> createMoveRequest(@Valid @RequestBody MoveRequest moveRequest) {
        MoveRequest savedRequest = moveRequestService.createMoveRequest(moveRequest);
        return ResponseEntity.status(201).body(savedRequest);
    }
    @GetMapping
    public ResponseEntity<List<MoveRequest>> getAllMoveRequests() {
        return ResponseEntity.ok(moveRequestService.getAllMoveRequests());
    }
}
