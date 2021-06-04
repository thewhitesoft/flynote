package com.edu.flynote.controller;

import com.edu.flynote.entity.Note;
import com.edu.flynote.repository.NoteRepository;
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

@SpringBootTest
@AutoConfigureMockMvc
class NoteControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private NoteRepository noteRepository;

    @Test
    void create() throws Exception {
        // Arrange
        String bodyJson = "{ \"note\": \"test note\" }";

        // Act
        mockMvc.perform(MockMvcRequestBuilders.post("/note/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bodyJson))
                .andExpect(status().isCreated());

        // Assert
        List<Note> resultNotes = noteRepository.findAll();
        Assertions.assertEquals(1, resultNotes.size());
        Assertions.assertEquals("test note", resultNotes.get(0).getNote());
        Assertions.assertNotNull(resultNotes.get(0).getId());
        Assertions.assertNotNull(resultNotes.get(0).getCreateDate());
    }

    @Test
    void list() throws Exception {
        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/note/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}