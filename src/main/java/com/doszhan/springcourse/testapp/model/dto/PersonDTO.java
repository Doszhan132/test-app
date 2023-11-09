package com.doszhan.springcourse.testapp.model.dto;


import com.doszhan.springcourse.testapp.model.Person;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
public class PersonDTO {
    private int id;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("birth_year")
    private int birthYear;


}
