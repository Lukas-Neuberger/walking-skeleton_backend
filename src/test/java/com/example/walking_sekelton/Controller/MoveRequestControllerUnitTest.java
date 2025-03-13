package com.example.walking_sekelton.Controller;

import com.example.walking_sekelton.controller.MoveRequestController;
import com.example.walking_sekelton.model.MoveRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(MoveRequestController.class)
class MoveRequestControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateMoveRequest() throws Exception {
        MoveRequest moveRequest = new MoveRequest(1,"Bob Baumeister", "Mühlgasse 45", "Mühlgasse 342", "2025-07-31");

        mockMvc.perform(post("/api/move-requests")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(moveRequest)))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldGetAllMoveRequests() throws Exception {
        mockMvc.perform(get("/api/move-requests"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").isNumber());
    }
}
