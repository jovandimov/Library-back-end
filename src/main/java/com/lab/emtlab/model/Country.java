package com.lab.emtlab.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Country {

    @Id
    @GeneratedValue
    private Long Id;

    private String name;

    private String continent;

    public Country() {

    }

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
