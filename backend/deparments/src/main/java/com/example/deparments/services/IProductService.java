package com.example.deparments.services;

import com.example.deparments.dto.ImagePostDto;
import com.example.deparments.dto.ProductPostDto;
import com.example.deparments.entities.Product;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IProductService {
    List<Product> getProducts();
    Product getProductById(Long id);
    Optional<Product> getProductByTitle(String title);
    List<Product> getProductsBetweenTwoDates(String firstDate, String lastDate) throws ParseException;
    List<Product> getProductsByCityId(Long cityId);
    List<Product> getProductsByCategoryId(Long categoryId);
    Product saveProduct(ProductPostDto productDto);
    Product updateProduct(ProductPostDto productDto);
    void deleteProduct(Long id);
}
