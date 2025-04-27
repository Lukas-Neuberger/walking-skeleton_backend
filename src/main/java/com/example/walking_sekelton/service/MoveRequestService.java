package com.example.walking_sekelton.service;

import com.example.walking_sekelton.model.MoveRequest;
import com.example.walking_sekelton.repository.MoveRequestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveRequestService {

  private final MoveRequestRepository moveRequestRepository;

  @Autowired
  public MoveRequestService(MoveRequestRepository moveRequestRepository) {
    this.moveRequestRepository = moveRequestRepository;
  }

  public MoveRequest createMoveRequest(MoveRequest moveRequest) {
    return moveRequestRepository.save(moveRequest);
  }

  public List<MoveRequest> getAllMoveRequests() {
    return moveRequestRepository.findAll();
  }
}
