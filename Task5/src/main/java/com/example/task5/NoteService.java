package com.example.task5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    public Note getNote(String name) {
        return noteRepository.getReferenceById(name);
    }

    public void deleteNote(String name) {
         noteRepository.deleteById(name);
    }

    public void updateNote(Note note) {
        noteRepository.updateNoteById(note.getName(), note.getNote());
    }

    public List<Note> getAll() {
        return noteRepository.findAll();
    }
}
