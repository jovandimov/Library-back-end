package com.lab.emtlab.service.impl;

import com.lab.emtlab.model.Author;
import com.lab.emtlab.model.Book;
import com.lab.emtlab.model.Country;
import com.lab.emtlab.model.enumerations.Category;
import com.lab.emtlab.model.exceptions.InvalidCountryIdException;
import com.lab.emtlab.repository.AuthorRepository;
import com.lab.emtlab.repository.BookRepository;
import com.lab.emtlab.repository.CountryRepository;
import com.lab.emtlab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    public BookServiceImpl(BookRepository bookRepository, CountryRepository countryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(InvalidCountryIdException::new);
    }

    @Override
    public Book save(String name, Category category, Long authorId, int availableCopies) {
        Author author = authorRepository.findById(authorId).orElseThrow(InvalidCountryIdException::new);
        Book book = new Book(name,category,author,availableCopies);
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book edit(Long id, String name, Category category, Long authorId, int availableCopies) {
        Book book = bookRepository.findById(id).orElseThrow(InvalidCountryIdException::new);
        book.setName(name);
        book.setCategory(category);
        Author author = authorRepository.findById(authorId).orElseThrow(InvalidCountryIdException::new);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        bookRepository.save(book);
        return book;
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void borrowBook(Long id) {
        //System.out.println(id);
        Book book = bookRepository.findById(id).orElseThrow(InvalidCountryIdException::new);
        if(book.getAvailableCopies() > 0){
            book.setAvailableCopies(book.getAvailableCopies() - 1);
        }
        bookRepository.save(book);
    }
}
