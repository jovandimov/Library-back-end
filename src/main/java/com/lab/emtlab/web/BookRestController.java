package com.lab.emtlab.web;

import com.lab.emtlab.model.Book;
import com.lab.emtlab.model.dto.BookDto;
import com.lab.emtlab.model.enumerations.Category;
import com.lab.emtlab.service.AuthorService;
import com.lab.emtlab.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
//@CrossOrigin("http://localhost:3000")
@CrossOrigin(origins = "*")
@RequestMapping("/api/books")
public class BookRestController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookRestController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public List<Book> findAll() {
        return this.bookService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        //System.out.println(id);
        if (bookService.findById(id) != null) {
            Book book = bookService.findById(id);
            return ResponseEntity.ok().body(book);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        System.out.println(bookDto);
        Category myCat = Category.NOVEL;
        if (!Objects.equals(bookDto.getCategory(), "")) {
            int category = Integer.parseInt(bookDto.getCategory());
            Category[] categories = Category.values();
            myCat = categories[category];
        }
        this.bookService.save(bookDto.getName(), myCat, bookDto.getAuthorId(), bookDto.getAvailableCopies());
        return ResponseEntity.ok().build();
    }
    @PutMapping("/edit")
    public ResponseEntity<Book> editBook(@RequestBody BookDto bookDto){
        //System.out.println(bookDto);
        Category myCat = Category.NOVEL;
        if (!Objects.equals(bookDto.getCategory(), "")) {
            int category = Integer.parseInt(bookDto.getCategory());
            Category[] categories = Category.values();
            myCat = categories[category];
        }
        this.bookService.edit(bookDto.getId(),bookDto.getName(), myCat, bookDto.getAuthorId(), bookDto.getAvailableCopies());
        return ResponseEntity.ok().build();
    }
    @PutMapping("/borrow/{id}")
    public void borrow(@PathVariable Long id){
        bookService.borrowBook(id);
    }


}
