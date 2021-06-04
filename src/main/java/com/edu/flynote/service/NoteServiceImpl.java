package com.edu.flynote.service;

import com.edu.flynote.entity.Note;
import com.edu.flynote.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository repository;

    @Autowired
    public NoteServiceImpl(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Note create(String note) {
        if (note == null || note.isEmpty())
            throw new RuntimeException("Note can't be null or empty");

        Note noteEntity = new Note();

        noteEntity.setNote(note);

        return repository.save(noteEntity);
    }

    @Override
    public List<Note> getAll() {
        return repository.findAllByOrderByCreateDateDesc();
    }
}
