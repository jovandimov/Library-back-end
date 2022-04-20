package com.lab.emtlab.service;

import com.lab.emtlab.model.Author;
import com.lab.emtlab.model.Book;
import com.lab.emtlab.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Book findById(Long id);

    Book save(String name, Category category, Long authorId, int availableCopies);

    Book edit(Long id, String name, Category category, Long authorId, int availableCopies);

    void deleteById(Long id);

    void borrowBook(Long id);
}
