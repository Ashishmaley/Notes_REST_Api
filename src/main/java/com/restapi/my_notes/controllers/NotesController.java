package com.restapi.my_notes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.my_notes.entity.Note;
import com.restapi.my_notes.service.NoteService;

import ch.qos.logback.core.pattern.parser.Node;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class NotesController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/AllNotes")
    public List<Note> requestMethodName() {
        return this.noteService.getAllNotes();
    }

    @GetMapping("/Note/{id}")
    public Note getMethodName(@PathVariable("id") int id) {
        Note note = noteService.findById(id);
        return note;
    }

    @PostMapping("/Note")
    public Note addBook(@RequestBody Note note) {
        noteService.addNote(note);
        return note;
    }

    @DeleteMapping("/Note/{id}")
    public void delNote(@PathVariable("id") int id) {
        noteService.deleteNote(id);
    }

    @DeleteMapping("/Notes")
    public void delNote() {
        noteService.deleteAllNote();
    }

    @PutMapping("/Note/{id}")
    public Note putMethodName(@RequestBody Note note, @PathVariable("id") int id) {
        return noteService.updateNote(note, id);
    }
}
