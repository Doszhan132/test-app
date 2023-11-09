package com.doszhan.springcourse.testapp.service;

import com.doszhan.springcourse.testapp.model.Book;
import com.doszhan.springcourse.testapp.model.dto.BookDTO;
import com.doszhan.springcourse.testapp.model.response.BookWithPersonResponse;

import java.util.List;

public interface BookService {
    List<BookDTO> getBooks();

    BookWithPersonResponse getBook(int id);


    void deleteBook(int id);

    void addBook(BookDTO bookDTO);

    void editBook(int id, Book book);

}
