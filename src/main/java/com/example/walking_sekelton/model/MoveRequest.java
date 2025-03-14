package com.example.walking_sekelton.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Old address is required")
    private String oldAddress;

    @NotBlank(message = "New address is required")
    private String newAddress;

    @NotBlank(message = "Date is required")
    private String date;

    public MoveRequest(int id, String bobBaumeister, String oldAddress, String newAddress, LocalDate parse) {
    }
}
