package com.example.deparments.services;

import com.example.deparments.entities.Feature;

import java.util.List;
import java.util.Optional;

public interface IFeatureService {
    List<Feature> getFeatures();
    Optional<Feature> getFeatureById(Long id);
    Optional<Feature> getFeatureByName(String name);
    Feature saveFeature(Feature feature);
    Feature updateFeature(Feature feature);
    void deleteFeature(Long id);
}
