package com.edu.flynote.repository;

import com.edu.flynote.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {
    List<Note> findAllByOrderByCreateDateDesc();
}
