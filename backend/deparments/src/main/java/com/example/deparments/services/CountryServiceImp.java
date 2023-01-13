package com.example.deparments.services;

import com.example.deparments.entities.Country;
import com.example.deparments.repositories.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImp implements ICountryService {

    @Autowired
    private ICountryRepository countryRepository;

    @Override
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> getCountryByName(String name) {
        return countryRepository.findByNombre(name);
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
