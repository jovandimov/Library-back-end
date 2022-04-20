package com.lab.emtlab.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;


    @ManyToOne
    @JsonManagedReference
    private Country country;

    //@OneToMany(mappedBy = "author")
    //@JsonBackReference
    @OneToMany
    private List<Book> books;

    public Author() {
    }
    public Author(String name, String surname, Country country){
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.books = null;
    }

    public Author(String name, String surname, Country country, List<Book> books) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.books = books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
