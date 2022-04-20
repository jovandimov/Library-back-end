package com.lab.emtlab.service;

import com.lab.emtlab.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Country findById(Long id);

    Country findByName(String name);

    Country save(String name, String continent);

    Country edit(Long id, String name,String continent);

    void deleteById(Long id);
}
