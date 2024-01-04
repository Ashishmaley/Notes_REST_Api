package com.restapi.my_notes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.restapi.my_notes.entity.*;
import com.restapi.my_notes.Dao.NoteRepo;

@Component
public class NoteService {
    @Autowired
    private NoteRepo noteRepo;

    public List<Note> getAllNotes() {
        List<Note> notes = (List<Note>) this.noteRepo.findAll();
        return notes;
    }

    public Note findById(int id) {
        Note note = noteRepo.findById(id);
        return note;
    }

    public Note addNote(Note note) {
        Note n = noteRepo.save(note);
        return n;
    }

    public void deleteNote(int id) {
        noteRepo.deleteById(id);
    }

    public void deleteAllNote() {
        noteRepo.deleteAll();
    }

    public Note updateBook(Note note, int id) {
        note.setId(id);
        noteRepo.save(note);
        return note;
    }

}
