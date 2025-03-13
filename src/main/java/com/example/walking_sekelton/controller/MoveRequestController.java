package com.example.walking_sekelton.controller;

import com.example.walking_sekelton.model.MoveRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/move-requests")
public class MoveRequestController {

    private final List<MoveRequest> moveRequests = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> createMoveRequest(@Valid @RequestBody MoveRequest moveRequest) {
        moveRequests.add(moveRequest);
        return ResponseEntity.status(201).body("Move request successfully created");
    }

    @GetMapping
    public ResponseEntity<List<MoveRequest>> getMoveRequests() {
        return ResponseEntity.ok(moveRequests);
    }
}
