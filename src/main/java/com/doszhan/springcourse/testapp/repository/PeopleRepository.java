package com.doszhan.springcourse.testapp.repository;

import com.doszhan.springcourse.testapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface PeopleRepository extends JpaRepository<Person,Integer> {

    void deleteByFullName(String fullName);




}
