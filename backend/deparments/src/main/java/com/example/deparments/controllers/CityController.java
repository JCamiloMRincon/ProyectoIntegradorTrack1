package com.example.deparments.controllers;

import com.example.deparments.dto.CityDto;
import com.example.deparments.entities.City;
import com.example.deparments.entities.Country;
import com.example.deparments.exceptions.ResourceNotFoundException;
import com.example.deparments.services.ICityService;
import com.example.deparments.services.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("/ciudades")
public class CityController {

    @Autowired
    private ICityService cityService;
    @Autowired
    private ICountryService countryService;

    @GetMapping
    public ResponseEntity<List<City>> getCities() {
        List<City> cities = cityService.getCities();
        return ResponseEntity.ok( cities );
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable("id") Long id)
            throws ResourceNotFoundException {
        Optional<City> city = cityService.getCityById(id);
        if ( city.isPresent() ) {
            return ResponseEntity.ok( city.get() );
        } else {
            throw new ResourceNotFoundException("The city was not found");
        }
    }

    @GetMapping("/nombre")
    public ResponseEntity<City> getCityByName(@RequestParam String name)
            throws ResourceNotFoundException {
        Optional<City> city = cityService.getCityByName(name);
        if ( city.isPresent() ) {
            return ResponseEntity.ok( city.get() );
        } else {
            throw new ResourceNotFoundException("There is not any city with the specified name");
        }
    }

    @PostMapping
    public ResponseEntity<City> saveCity(@RequestBody CityDto cityDto) throws ResourceNotFoundException {
        String cityName = cityDto.getCityName();
        String countryName = cityDto.getCountryName();
        Optional<Country> countryByName = countryService.getCountryByName(countryName);

        if ( countryByName.isPresent() ) {
            City cityToBeAdded = new City(cityName, countryByName.get());
            return ResponseEntity.ok( cityService.saveCity(cityToBeAdded) );
        } else {
            throw new ResourceNotFoundException("The country does not exist in the DB. Please try again");
        }

    }

    @PutMapping
    public ResponseEntity<City> updateCity(@RequestBody City city)
            throws ResourceNotFoundException {
        Optional<City> searchedCity = cityService.getCityById( city.getId() );
        if ( searchedCity.isPresent() ) {
            return ResponseEntity.ok( cityService.updateCity(city) );
        } else {
            throw new ResourceNotFoundException("The city was not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable("id") Long id)
            throws ResourceNotFoundException {
        Optional<City> searchedCity = cityService.getCityById(id);
        if ( searchedCity.isPresent() ) {
            cityService.deleteCity(id);
            return ResponseEntity.ok("The city with ID: " + id + " was deleted successfully");
        } else {
            throw new ResourceNotFoundException("The city was not found");
        }
    }

}
