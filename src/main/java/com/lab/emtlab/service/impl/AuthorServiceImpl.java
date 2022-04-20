package com.lab.emtlab.service.impl;

import com.lab.emtlab.model.Author;
import com.lab.emtlab.model.Country;
import com.lab.emtlab.model.exceptions.InvalidCountryIdException;
import com.lab.emtlab.repository.AuthorRepository;
import com.lab.emtlab.repository.BookRepository;
import com.lab.emtlab.repository.CountryRepository;
import com.lab.emtlab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final BookRepository bookRepository;
    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(InvalidCountryIdException::new);
    }

    @Override
    public Author findByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public Author save(String name, String surname, Long countryId, List<Long> booksId) {
        return null;
        //TODO
    }

    @Override
    public Author save(String name, String surname, Long countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(InvalidCountryIdException::new);
        Author author = new Author(name,surname,country);
        return authorRepository.save(author);

    }

    @Override
    public Author edit(Long id, String name, String surname, Long countryId, List<Long> booksId) {
        return null;
        //TODO
    }

    @Override
    public Author edit(Long id, String name, String surname, Long countryId) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
