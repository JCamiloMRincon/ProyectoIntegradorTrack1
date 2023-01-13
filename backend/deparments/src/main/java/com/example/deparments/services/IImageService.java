package com.example.deparments.services;

import com.example.deparments.entities.Image;

import java.util.List;
import java.util.Optional;

public interface IImageService {
    List<Image> getImages();
    List<Image> getImagesByProductId(Long productId);
    Image getImageById(Long id);
    Image getImageByTitle(String title);
    Image saveImage(Image image);
    Image updateImage(Image image);
    void deleteImage(Long id);
}
