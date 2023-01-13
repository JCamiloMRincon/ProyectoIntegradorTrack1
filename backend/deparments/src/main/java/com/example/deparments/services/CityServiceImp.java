package com.example.deparments.services;

import com.example.deparments.entities.City;
import com.example.deparments.repositories.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImp implements ICityService {

    @Autowired
    private ICityRepository cityRepository;

    @Override
    public List<City> getCities() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public Optional<City> getCityByName(String name) {
        return cityRepository.findByNombre(name);
    }

    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City updateCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
