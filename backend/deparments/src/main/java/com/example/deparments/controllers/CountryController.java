package com.example.deparments.controllers;

import com.example.deparments.entities.Country;
import com.example.deparments.exceptions.ResourceNotFoundException;
import com.example.deparments.services.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("/paises")
public class CountryController {

    @Autowired
    private ICountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> getCountries() {
        List<Country> countries = countryService.getCountries();
        return ResponseEntity.ok( countries );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable("id") Long id)
            throws ResourceNotFoundException {
        Optional<Country> country = countryService.getCountryById(id);
        if ( country.isPresent() ) {
            return ResponseEntity.ok( country.get() );
        } else {
            throw new ResourceNotFoundException("The country was not found");
        }
    }

    @GetMapping("/nombre")
    public ResponseEntity<Country> getCountryByName(@RequestParam String name)
            throws ResourceNotFoundException {
        Optional<Country> country = countryService.getCountryByName(name);
        if ( country.isPresent() ) {
            return ResponseEntity.ok( country.get() );
        } else {
            throw new ResourceNotFoundException("There is not any country with the specified name");
        }
    }

    @PostMapping
    public ResponseEntity<Country> saveCountry(@RequestBody Country country) {
        return ResponseEntity.ok( countryService.saveCountry(country) );
    }

    @PutMapping
    public ResponseEntity<Country> updateCountry(@RequestBody Country country)
            throws ResourceNotFoundException {
        Optional<Country> searchedCountry = countryService.getCountryById( country.getId() );
        if ( searchedCountry.isPresent() ) {
            return ResponseEntity.ok( countryService.updateCountry(country) );
        } else {
            throw new ResourceNotFoundException("The country was not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable("id") Long id)
            throws ResourceNotFoundException {
        Optional<Country> searchedCountry = countryService.getCountryById(id);
        if ( searchedCountry.isPresent() ) {
            countryService.deleteCountry(id);
            return ResponseEntity.ok("The country with ID: " + id + " was deleted successfully");
        } else {
            throw new ResourceNotFoundException("The country was not found");
        }
    }

}
