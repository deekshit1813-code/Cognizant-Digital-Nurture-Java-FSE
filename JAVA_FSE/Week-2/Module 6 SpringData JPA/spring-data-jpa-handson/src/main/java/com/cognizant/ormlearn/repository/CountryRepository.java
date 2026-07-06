package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    Country findByName(String name);

    List<Country> findByNameContaining(String text);

    List<Country> findByNameStartingWith(String prefix);

}