package com.example.task6;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    Iterable<Book> books() {
        return bookRepository.findAll();
    }

    @QueryMapping
    Optional<Book> bookById(@Argument Long id) {
        return bookRepository.findById(id);
    }

    @MutationMapping
    public Book addBook(@Argument(name = "book") BookInput book) {
        Author author = authorRepository.findById(book.getAuthorId()).orElseThrow(() -> new IllegalArgumentException("author not found"));
        Book b = Book.builder()
                .name(book.getName())
                .genre(book.getGenre())
                .author(author).build();
        return bookRepository.save(b);
    }
}
