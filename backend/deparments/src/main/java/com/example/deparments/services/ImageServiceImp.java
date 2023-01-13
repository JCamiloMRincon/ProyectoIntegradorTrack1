package com.example.deparments.services;

import com.example.deparments.entities.Image;
import com.example.deparments.repositories.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImp implements IImageService {

    @Autowired
    private IImageRepository imageRepository;


    @Override
    public List<Image> getImages() {
        return imageRepository.findAll();
    }

    @Override
    public List<Image> getImagesByProductId(Long productId) {
        return imageRepository.findByProductId(productId);
    }

    @Override
    public Image getImageById(Long id) {
        Optional<Image> image = imageRepository.findById(id);
        if( image.isPresent() ) {
            return image.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "The image with id " + id + " does not exist");
        }
    }

    @Override
    public Image getImageByTitle(String title) {
        Optional<Image> image = imageRepository.findByTitulo(title);
        if( image.isPresent() ) {
            return image.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "The image with title " + title + " does not exist");
        }
    }

    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image updateImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}
