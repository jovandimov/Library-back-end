package com.lab.emtlab.config;

import com.lab.emtlab.model.Author;
import com.lab.emtlab.model.Country;
import com.lab.emtlab.model.enumerations.Category;
import com.lab.emtlab.service.AuthorService;
import com.lab.emtlab.service.BookService;
import com.lab.emtlab.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.*;
import lombok.Data;

import javax.persistence.*;


@Component
public class DataInitializer {
    private final AuthorService authorService;

    private final BookService bookService;

    private final CountryService countryService;

    public DataInitializer(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void initData() {
        Long country1Id = this.countryService.save("Macedonia", "Europe").getId();
        Long country2Id = this.countryService.save("England", "Europe").getId();

        Long author1Id = this.authorService.save("J.K", "Rowling", country2Id).getId();
        Long author2Id = this.authorService.save("Blaze", "Koneski", country1Id).getId();
        Long author3Id = this.authorService.save("Name","Surname",country2Id).getId();

        this.bookService.save("Harry Poter", Category.FANTASY,author1Id,10);
        this.bookService.save("New book",Category.DRAMA,author3Id,15);
    }
}
