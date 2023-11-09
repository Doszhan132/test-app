package com.doszhan.springcourse.testapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="books")
public class Book {
    @Id
    private int id;
    private String name;
    private String author;
    private int year;
    private int personId;
}
