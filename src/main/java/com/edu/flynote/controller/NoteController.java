package com.edu.flynote.controller;

import com.edu.flynote.action.CreateNoteAction;
import com.edu.flynote.controller.dto.CreateNoteDto;
import com.edu.flynote.entity.Note;
import com.edu.flynote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class NoteController {

    private final NoteService noteService;
    private final CreateNoteAction createNoteAction;

    @Autowired
    public NoteController(NoteService noteService,
                          CreateNoteAction createNoteAction) {
        this.noteService = noteService;
        this.createNoteAction = createNoteAction;
    }

    @PostMapping("note/create")
    @ResponseStatus(value = CREATED)
    public void create(@RequestBody CreateNoteDto dto,
                       HttpServletRequest request) {
        createNoteAction.execute(dto.getNote(), request);
    }

    @GetMapping("note/list")
    public List<Note> list() {
        return noteService.getAll();
    }
}
