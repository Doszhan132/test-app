package com.doszhan.springcourse.testapp.controller;


import com.doszhan.springcourse.testapp.model.Person;
import com.doszhan.springcourse.testapp.model.dto.PersonDTO;
import com.doszhan.springcourse.testapp.model.response.PersonWithBooksResponse;
import com.doszhan.springcourse.testapp.service.PeopleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;

    @GetMapping()
    public List<PersonDTO> index(){
        return peopleService.getPeople();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonWithBooksResponse showPerson(@PathVariable("id") int id){
        return peopleService.showPerson(id);
    }


    @PostMapping("/new")
    public void addPerson(@RequestBody @Valid PersonDTO person ){
        peopleService.addPerson(person);

    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam(value = "fullName") String fullName){
        peopleService.deletePerson(fullName);
    }

    @PostMapping("/{id}/edit")
    public void editPerson(@PathVariable("id") int id, @RequestBody @Valid PersonDTO request){
        peopleService.editPerson(request, id);
    }

}
