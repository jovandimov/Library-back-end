package com.lab.emtlab.service;

import com.lab.emtlab.model.Author;
import com.lab.emtlab.model.Book;
import com.lab.emtlab.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Author findById(Long id);

    Author findByName(String name);

    Author save(String name, String surname, Long countryId, List<Long> booksId);

    Author save(String name, String surname, Long countryId);

    Author edit(Long id,String name,String surname,Long countryId,List<Long> booksId);

    Author edit(Long id, String name, String surname, Long countryId);

    void deleteById(Long id);
}
