package com.doszhan.springcourse.testapp.model.dto;

import com.doszhan.springcourse.testapp.model.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
public class BookDTO {

    private int id;
    private String name;
    private String author;
    private int year;


}
