package com.example.walking_sekelton.repository;

import com.example.walking_sekelton.model.MoveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoveRequestRepository extends JpaRepository<MoveRequest, Long> {}
