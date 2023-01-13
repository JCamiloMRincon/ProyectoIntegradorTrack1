package com.example.deparments.services;

import com.example.deparments.entities.Feature;
import com.example.deparments.repositories.IFeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeatureServiceImp implements IFeatureService {

    @Autowired
    private IFeatureRepository featureRepository;

    @Override
    public List<Feature> getFeatures() {
        return featureRepository.findAll();
    }

    @Override
    public Optional<Feature> getFeatureById(Long id) {
        return featureRepository.findById(id);
    }

    @Override
    public Optional<Feature> getFeatureByName(String name) {
        return featureRepository.findByNombre(name);
    }

    @Override
    public Feature saveFeature(Feature feature) {
        return featureRepository.save(feature);
    }

    @Override
    public Feature updateFeature(Feature feature) {
        return featureRepository.save(feature);
    }

    @Override
    public void deleteFeature(Long id) {
        featureRepository.deleteById(id);
    }
}
