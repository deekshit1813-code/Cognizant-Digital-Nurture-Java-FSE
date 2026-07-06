package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @RequestMapping("/country")
    public Country getCountryIndia() {

        LOGGER.info("START");

        Country country = countryService.getCountry();

        LOGGER.info("END");

        return country;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {

        LOGGER.info("START");

        List<Country> countries = countryService.getAllCountries();

        LOGGER.info("END");

        return countries;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {

        LOGGER.info("START");

        Country country = countryService.getCountry(code);

        LOGGER.info("END");

        return country;
    }

    @PostMapping("/countries")
    public Country addCountry(@Valid @RequestBody Country country) {

        LOGGER.info("START");

        Country newCountry = countryService.addCountry(country);

        LOGGER.info("END");

        return newCountry;
    }

    @PutMapping("/countries")
    public Country updateCountry(@Valid @RequestBody Country country)
            throws CountryNotFoundException {

        LOGGER.info("START");

        Country updatedCountry = countryService.updateCountry(country);

        LOGGER.info("END");

        return updatedCountry;
    }

    @DeleteMapping("/countries/{code}")
    public void deleteCountry(@PathVariable String code)
            throws CountryNotFoundException {

        LOGGER.info("START");

        countryService.deleteCountry(code);

        LOGGER.info("END");
    }
}