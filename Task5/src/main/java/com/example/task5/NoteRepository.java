package com.example.task5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, String> {

    @Modifying
    @Query("update notes n set n.note = ?2 where n.name = ?1")
    void updateNoteById(String name, String note);
}
