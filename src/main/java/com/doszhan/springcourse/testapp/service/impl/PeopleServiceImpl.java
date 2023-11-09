package com.doszhan.springcourse.testapp.service.impl;

import com.doszhan.springcourse.testapp.model.Book;
import com.doszhan.springcourse.testapp.model.Person;
import com.doszhan.springcourse.testapp.model.dto.BookDTO;
import com.doszhan.springcourse.testapp.model.dto.PersonDTO;
import com.doszhan.springcourse.testapp.model.response.PersonWithBooksResponse;
import com.doszhan.springcourse.testapp.repository.BooksRepository;
import com.doszhan.springcourse.testapp.repository.PeopleRepository;
import com.doszhan.springcourse.testapp.service.PeopleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService {

    private final PeopleRepository peopleRepository;
    private final BooksRepository booksRepository;



    @Override
    public List<PersonDTO> getPeople() {
        List<Person> people = peopleRepository.findAll();
        return people.stream()
                .map(person ->{
                    PersonDTO personDTO=new PersonDTO();
                    personDTO.setFullName(person.getFullName());
                    personDTO.setBirthYear(person.getBirthYear());
                    personDTO.setId(person.getId());
                    return personDTO;
                })
                .toList();
    }

    @Override
    public PersonWithBooksResponse showPerson(Integer id) {
        Optional<Person> optionalPerson = peopleRepository.findById(id);
        if(optionalPerson.isPresent()) {
            Person person=optionalPerson.get();
            List<Book> books = booksRepository.findAllByPersonId(id);

            return PersonWithBooksResponse.builder()
                    .fullName(person.getFullName())
                    .birthYear(person.getBirthYear())
                    .id(person.getId())
                    .books(books.stream()
                            .map(book -> {
                                BookDTO bookDTO=new BookDTO();
                                bookDTO.setAuthor(book.getAuthor());
                                bookDTO.setName(book.getName());
                                bookDTO.setYear(book.getYear());
                                bookDTO.setId(book.getId());
                                return bookDTO;
                            }).toList())
                    .build();
        }
        return null;
    }

    @Override
    public void addPerson(PersonDTO person) {
        peopleRepository.save(Person.builder()
                .fullName(person.getFullName())
                .birthYear(person.getBirthYear())
                .build());

    }

    @Override
    @Transactional
    public void deletePerson(String fullName) {
        peopleRepository.deleteByFullName(fullName);
    }

    @Override
    public void editPerson(PersonDTO request, int id){
        Optional<Person> person = peopleRepository.findById(id);
        if(person.isPresent()){
            Person newPerson=person.get();
            newPerson.setFullName(request.getFullName());
            newPerson.setBirthYear(request.getBirthYear());
            peopleRepository.save(newPerson);
        }
    }
}
