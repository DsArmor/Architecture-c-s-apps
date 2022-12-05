package com.example.task6;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 2)
    private Long id;

    @Column
    private String name;

    @Column
    private String genre;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

}
