package com.example.deparments.controllers;

import com.example.deparments.dto.ImageGetDto;
import com.example.deparments.dto.ImagePostDto;
import com.example.deparments.entities.Image;
import com.example.deparments.entities.Product;
import com.example.deparments.exceptions.ResourceNotFoundException;
import com.example.deparments.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("/imagenes")
public class ImageController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IImageService imageService;
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<List<ImageGetDto>> getImages() {
        List<ImageGetDto> imagesDto = imageService.getImages().stream()
                                        .map(image -> modelMapper.map(image, ImageGetDto.class))
                                        .collect(Collectors.toList());
        return ResponseEntity.ok( imagesDto );
    }

    @GetMapping("/producto/{productId}")
    public ResponseEntity<List<ImageGetDto>> getImagesByProductId(@PathVariable("productId") Long productId) {
        List<ImageGetDto> imagesDto = imageService.getImagesByProductId(productId).stream()
                .map(image -> modelMapper.map(image, ImageGetDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok( imagesDto );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageGetDto> getImageById(@PathVariable("id") Long id) {
        Image image = imageService.getImageById(id);
        ImageGetDto imageGetDto = this.modelMapper.map(image, ImageGetDto.class);
        return ResponseEntity.ok( imageGetDto );
    }

    @GetMapping("/titulo")
    public ResponseEntity<ImageGetDto> getImageByTitle(@RequestParam String title) {
        Image image = imageService.getImageByTitle(title);
        ImageGetDto imageGetDto = this.modelMapper.map(image, ImageGetDto.class);
        return ResponseEntity.ok( imageGetDto );
    }

    /* @PostMapping
    public ResponseEntity<ImageGetDto> saveImage(@RequestBody ImagePostDto imagePostDto) throws ResourceNotFoundException {
        Long productId = imageGetDto.getIdProduct();
        String imageTitle = imageGetDto.getTitle();
        String imageUrl = imageGetDto.getUrl();
        Optional<Product> productById = productService.getProductById(productId);

        if( productById.isPresent() ) {
            Image imageToBeAdded = new Image( productById.get(), imageTitle, imageUrl );
            return ResponseEntity.ok( imageService.saveImage( imageToBeAdded ) );
        } else {
            throw new ResourceNotFoundException("The product does not exist in the DB. Please try again");
        }
    } */

    /* @PutMapping
    public ResponseEntity<Image> updateImage(@RequestBody Image image)
            throws ResourceNotFoundException {
        Optional<Image> searchedImage = imageService.getImageById( image.getId() );
        if ( searchedImage.isPresent() ) {
            return ResponseEntity.ok( imageService.updateImage(image) );
        } else {
            throw new ResourceNotFoundException("The image was not found");
        }
    } */

    /* @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable("id") Long id)
            throws ResourceNotFoundException {
        Optional<Image> searchedImage = imageService.getImageById(id);
        if ( searchedImage.isPresent() ) {
            imageService.deleteImage(id);
            return ResponseEntity.ok("The image with ID: " + id + " was deleted successfully");
        } else {
            throw new ResourceNotFoundException("The image was not found");
        }
    } */

}
