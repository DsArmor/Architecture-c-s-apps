package com.example.task6;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorInput {

    @JsonProperty("firstName")
    String firstName;

    @JsonProperty("middleName")
    String middleName;

    @JsonProperty("lastName")
    String lastName;

    AuthorInput(String firstName) {
        this.firstName = firstName;
    }

    AuthorInput(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
