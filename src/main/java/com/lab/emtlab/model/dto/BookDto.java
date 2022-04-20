package com.lab.emtlab.model.dto;

import lombok.Data;

@Data
public class BookDto {
    Long id;

    String name;

    String category;

    Long authorId;

    int availableCopies;

    public BookDto(){}

    public BookDto(String name, String category, Long authorId, int availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }
    public BookDto(Long id, String name, String category, Long authorId, int availableCopies) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }
}
