package com.example.task6;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    Iterable<Author> authors() {
        return authorRepository.findAll();
    }

    @QueryMapping
    Optional<Author> authorById(@Argument Long id) {
        return authorRepository.findById(id);
    }

    @MutationMapping
    public Author addAuthor(@Argument(name = "author") AuthorInput author) {
        System.out.println(author.lastName);
        Author a = Author.builder()
                .firstName(author.getFirstName())
                .middleName(author.getMiddleName())
                .lastName(author.getLastName()).build();
        return authorRepository.save(a);
    }
}
