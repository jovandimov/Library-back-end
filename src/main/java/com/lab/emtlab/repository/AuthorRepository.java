package com.lab.emtlab.repository;

import com.lab.emtlab.model.Author;
import com.lab.emtlab.model.Book;
import com.lab.emtlab.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    Author findByName(String name);
}
