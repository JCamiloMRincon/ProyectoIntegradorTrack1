package com.example.deparments.services;

import com.example.deparments.entities.City;

import java.util.List;
import java.util.Optional;

public interface ICityService {
    List<City> getCities();
    Optional<City> getCityById(Long id);
    Optional<City> getCityByName(String name);
    City saveCity(City city);
    City updateCity(City city);
    void deleteCity(Long id);
}
