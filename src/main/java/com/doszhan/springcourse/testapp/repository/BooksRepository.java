package com.doszhan.springcourse.testapp.repository;

import com.doszhan.springcourse.testapp.model.Book;
import com.doszhan.springcourse.testapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, Integer> {
    void deleteById(int id);

    List<Book> findAllByPersonId(int id);

}
