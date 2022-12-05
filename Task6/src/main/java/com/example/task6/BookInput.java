package com.example.task6;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookInput {

    private String name;

    private String genre;

    private Long authorId;

    BookInput(String name) {
        this.name = name;
    }

    BookInput(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }
}
