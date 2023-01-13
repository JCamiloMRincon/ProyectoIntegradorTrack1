package com.example.deparments.controllers;

import com.example.deparments.entities.Feature;
import com.example.deparments.exceptions.ResourceNotFoundException;
import com.example.deparments.services.IFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("/caracteristicas")
public class FeatureController {

    @Autowired
    private IFeatureService featureService;

    @GetMapping
    public ResponseEntity<List<Feature>> getFeatures() {
        List<Feature> features = featureService.getFeatures();
        return ResponseEntity.ok( features );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feature> getFeatureById(@PathVariable("id") Long id)
            throws ResourceNotFoundException {
        Optional<Feature> feature = featureService.getFeatureById(id);
        if ( feature.isPresent() ) {
            return ResponseEntity.ok( feature.get() );
        } else {
            throw new ResourceNotFoundException("The feature was not found");
        }
    }

    @GetMapping("/nombre")
    public ResponseEntity<Feature> getFeatureByName(@RequestParam String name)
            throws ResourceNotFoundException {
        Optional<Feature> feature = featureService.getFeatureByName(name);
        if ( feature.isPresent() ) {
            return ResponseEntity.ok( feature.get() );
        } else {
            throw new ResourceNotFoundException("There is not any feature with the specified name");
        }
    }

    @PostMapping
    public ResponseEntity<Feature> saveFeature(@RequestBody Feature feature) {
        return ResponseEntity.ok( featureService.saveFeature(feature) );
    }

    @PutMapping
    public ResponseEntity<Feature> updateFeature(@RequestBody Feature feature)
            throws ResourceNotFoundException {
        Optional<Feature> searchedFeature = featureService.getFeatureById( feature.getId() );
        if ( searchedFeature.isPresent() ) {
            return ResponseEntity.ok( featureService.updateFeature(feature) );
        } else {
            throw new ResourceNotFoundException("The feature was not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeature(@PathVariable("id") Long id)
            throws ResourceNotFoundException {
        Optional<Feature> searchedFeature = featureService.getFeatureById(id);
        if ( searchedFeature.isPresent() ) {
            featureService.deleteFeature(id);
            return ResponseEntity.ok("The feature with ID: " + id + " was deleted successfully");
        } else {
            throw new ResourceNotFoundException("The feature was not found");
        }
    }

}
