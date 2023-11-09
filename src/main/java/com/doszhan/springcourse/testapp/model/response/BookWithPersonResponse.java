package com.doszhan.springcourse.testapp.model.response;

import com.doszhan.springcourse.testapp.model.dto.BookDTO;
import com.doszhan.springcourse.testapp.model.dto.PersonDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@RequiredArgsConstructor
@SuperBuilder
@Data
public class BookWithPersonResponse extends BookDTO {
    @JsonProperty("book_holder")
    private PersonDTO bookHolder;
}
