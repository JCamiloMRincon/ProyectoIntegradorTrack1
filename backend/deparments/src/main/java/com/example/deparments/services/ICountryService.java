package com.example.deparments.services;

import com.example.deparments.entities.Country;

import java.util.List;
import java.util.Optional;

public interface ICountryService {
    List<Country> getCountries();
    Optional<Country> getCountryById(Long id);
    Optional<Country> getCountryByName(String name);
    Country saveCountry(Country country);
    Country updateCountry(Country country);
    void deleteCountry(Long id);

}
