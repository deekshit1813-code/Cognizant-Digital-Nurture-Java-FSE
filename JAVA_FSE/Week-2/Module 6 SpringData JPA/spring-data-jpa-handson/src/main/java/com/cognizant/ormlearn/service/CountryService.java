package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.entity.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountry(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country findCountryByName(String name) {
        return countryRepository.findByName(name);
    }

    public List<Country> findCountryContaining(String text) {
        return countryRepository.findByNameContaining(text);
    }

    public List<Country> findCountryStartingWith(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }
}