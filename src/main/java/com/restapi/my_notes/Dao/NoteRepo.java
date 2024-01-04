package com.restapi.my_notes.Dao;

import org.springframework.data.repository.CrudRepository;

import com.restapi.my_notes.entity.Note;

public interface NoteRepo extends CrudRepository<Note, Integer> {
    public Note findById(int id);
}
