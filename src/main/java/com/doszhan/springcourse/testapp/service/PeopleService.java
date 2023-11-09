package com.doszhan.springcourse.testapp.service;

import com.doszhan.springcourse.testapp.model.Person;

import com.doszhan.springcourse.testapp.model.dto.PersonDTO;
import com.doszhan.springcourse.testapp.model.response.PersonWithBooksResponse;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;


public interface PeopleService {

    List<PersonDTO> getPeople();

    PersonWithBooksResponse showPerson(Integer id);


    void addPerson(PersonDTO person);


    void deletePerson(String fullName);

    void editPerson(PersonDTO person, int id);
}
