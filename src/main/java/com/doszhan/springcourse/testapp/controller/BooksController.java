package com.doszhan.springcourse.testapp.controller;

import com.doszhan.springcourse.testapp.model.Book;
import com.doszhan.springcourse.testapp.model.dto.BookDTO;
import com.doszhan.springcourse.testapp.model.response.BookWithPersonResponse;
import com.doszhan.springcourse.testapp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BooksController {
    private final BookService bookService;


    @GetMapping()
    public List<BookDTO> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public BookWithPersonResponse getBook(@PathVariable("id")int id){
        return bookService.getBook(id);
    }

    @PostMapping("/new")
    public void addBook(@RequestBody BookDTO bookDTO){
        bookService.addBook(bookDTO);
    }

    @PostMapping("/{id}/edit")
    public void editBook(@PathVariable("id")int id, @RequestBody Book book){
        bookService.editBook(id,book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id")int id){
        bookService.deleteBook(id);
    }




}
