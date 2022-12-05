package com.example.task5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @MessageMapping("/note/add")
    @SendTo("/topic/note/add")
    public Note addNote(Note note) {
        System.out.println("Yes, added");
        System.out.println(note.getName());
        return noteService.addNote(note);
    }

    @MessageMapping("/note/get")
    @SendTo("/topic/note/get")
    public Note getNote(String name) {
        return noteService.getNote(name);
    }

    @MessageMapping("/note/all")
    @SendTo("/topic/note/all")
    public List<Note> getAll() {
        return noteService.getAll();
    }

}
