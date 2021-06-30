package com.edu.flynote.controller;

import com.edu.flynote.entity.Note;
import com.edu.flynote.repository.NoteRepository;
import com.edu.flynote.repository.UserAgentWhitelistRepository;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DBRider
@SpringBootTest
@AutoConfigureMockMvc
class NoteControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private NoteRepository noteRepository;

    @Test
    @DataSet(cleanBefore = true, cleanAfter = true, value = "create.json")
    @ExpectedDataSet("create__expected.json")
    void create() throws Exception {
        // Arrange
        String bodyJson = "{ \"note\": \"test note\" }";

        // Act
        mockMvc.perform(MockMvcRequestBuilders.post("/note/create")
                                              .header("User-agent", "Java")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bodyJson))
                .andExpect(status().isCreated());
    }

    @Test
    void list() throws Exception {
        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/note/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}