package com.lab.emtlab.service.impl;

import com.lab.emtlab.model.Country;
import com.lab.emtlab.model.exceptions.InvalidCountryIdException;
import com.lab.emtlab.repository.CountryRepository;
import com.lab.emtlab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(InvalidCountryIdException::new);
    }

    @Override
    public Country findByName(String name) {
        return countryRepository.findByName(name);
    }

    @Override
    public Country save(String name, String continent) {
        Country country = new Country(name,continent);
        countryRepository.save(country);
        return country;
    }

    @Override
    public Country edit(Long id, String name, String continent) {
        Country country = this.countryRepository.findById(id).orElseThrow(InvalidCountryIdException::new);
        country.setName(name);
        country.setContinent(continent);
        this.countryRepository.save(country);
        return country;
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
