package com.doszhan.springcourse.testapp.model.response;

import com.doszhan.springcourse.testapp.model.Book;
import com.doszhan.springcourse.testapp.model.dto.BookDTO;
import com.doszhan.springcourse.testapp.model.dto.PersonDTO;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@RequiredArgsConstructor
@SuperBuilder
@Data
public class PersonWithBooksResponse extends PersonDTO {
    private List<BookDTO> books;
}
