package com.example.task5;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "notes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Note {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "note")
    private String note;
}
