package com.edu.flynote.action;

import com.edu.flynote.check.SpamChecker;
import com.edu.flynote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class CreateNoteAction {

    private final NoteService noteService;
    private final List<SpamChecker> checkers;

    @Autowired
    public CreateNoteAction(NoteService noteService, List<SpamChecker> checkers) {
        this.noteService = noteService;
        this.checkers = checkers;
    }

    public void execute(String note, HttpServletRequest request) {
        checkers.forEach(spamChecker -> spamChecker.execute(request));

        noteService.create(note);
    }
}
