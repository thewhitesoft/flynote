package com.edu.flynote.controller;

import com.edu.flynote.controller.dto.CreateNoteDto;
import com.edu.flynote.entity.Note;
import com.edu.flynote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("note/create")
    @ResponseStatus(value = CREATED)
    public void create(@RequestBody CreateNoteDto dto) {
        noteService.create(dto.getNote());
    }

    @GetMapping("note/list")
    public List<Note> list() {
        return noteService.getAll();
    }
}
