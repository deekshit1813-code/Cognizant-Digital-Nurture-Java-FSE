package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryService.class);

    private final ApplicationContext context =
            new ClassPathXmlApplicationContext("country.xml");

    @SuppressWarnings("unchecked")
    private final List<Country> countryList =
            (List<Country>) context.getBean("countryList");

    public Country getCountry() {

        LOGGER.info("START");

        Country country = context.getBean("india", Country.class);

        LOGGER.info("END");

        return country;
    }

    public List<Country> getAllCountries() {

        LOGGER.info("START");

        LOGGER.info("END");

        return countryList;
    }

    public Country getCountry(String code) throws CountryNotFoundException {

        LOGGER.info("START");

        for (Country country : countryList) {
            if (country.getCode().equalsIgnoreCase(code)) {
                LOGGER.info("END");
                return country;
            }
        }

        LOGGER.info("END");

        throw new CountryNotFoundException();
    }

    public Country addCountry(Country country) {

        LOGGER.info("START");

        countryList.add(country);

        LOGGER.info("END");

        return country;
    }

    public Country updateCountry(Country country) throws CountryNotFoundException {

        LOGGER.info("START");

        for (Country c : countryList) {
            if (c.getCode().equalsIgnoreCase(country.getCode())) {
                c.setName(country.getName());

                LOGGER.info("END");

                return c;
            }
        }

        LOGGER.info("END");

        throw new CountryNotFoundException();
    }

    public void deleteCountry(String code) throws CountryNotFoundException {

        LOGGER.info("START");

        Country country = getCountry(code);

        countryList.remove(country);

        LOGGER.info("END");
    }
}