package com.edu.flynote.service;

import com.edu.flynote.entity.Note;

import java.util.List;

public interface NoteService {

    Note create(String note);

    List<Note> getAll();

}
