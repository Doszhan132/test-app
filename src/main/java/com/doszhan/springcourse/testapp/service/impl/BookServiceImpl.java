package com.doszhan.springcourse.testapp.service.impl;

import com.doszhan.springcourse.testapp.model.Book;
import com.doszhan.springcourse.testapp.model.Person;
import com.doszhan.springcourse.testapp.model.dto.BookDTO;
import com.doszhan.springcourse.testapp.model.dto.PersonDTO;
import com.doszhan.springcourse.testapp.model.response.BookWithPersonResponse;
import com.doszhan.springcourse.testapp.repository.BooksRepository;
import com.doszhan.springcourse.testapp.repository.PeopleRepository;
import com.doszhan.springcourse.testapp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BooksRepository booksRepository;
    private final PeopleRepository peopleRepository;
    @Override
    public List<BookDTO> getBooks(){
        List<Book> books= booksRepository.findAll();
        return books.stream()
                .map(book -> {
                    BookDTO bookDTO =new BookDTO();
                    bookDTO.setId(book.getId());
                    bookDTO.setName(book.getName());
                    bookDTO.setAuthor(book.getAuthor());
                    bookDTO.setYear(book.getYear());
                    return bookDTO;
                }).toList();
    }

    @Override
    public BookWithPersonResponse getBook(int id) {
        Optional<Book> optionalBook = booksRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            Optional<Person> personOptional = peopleRepository.findById(book.getPersonId());

            PersonDTO personDTO = personOptional.map(person -> PersonDTO.builder()
                    .fullName(person.getFullName())
                    .id(person.getId())
                    .birthYear(person.getBirthYear())
                    .build()
            ).orElse(null);

            return BookWithPersonResponse.builder()
                    .name(book.getName())
                    .id(book.getId())
                    .author(book.getAuthor())
                    .year(book.getYear())
                    .bookHolder(personDTO)
                    .build();
        }

        return null;
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        booksRepository.deleteById(id);
    }

    @Override
    public void addBook(BookDTO bookDTO) {
        booksRepository.save(Book.builder()
                        .year(bookDTO.getYear())
                        .name(bookDTO.getName())
                        .author(bookDTO.getAuthor())
                        .build());
    }

    @Override
    public void editBook(int id, Book book) {
        booksRepository.save(Book.builder()
                        .name(book.getName())
                        .year(book.getYear())
                        .author(book.getAuthor())
                        .id(id)
                        .build());
    }


}
