package com.example.deparments.controllers;

import com.example.deparments.dto.ProductGetDto;
import com.example.deparments.dto.ProductPostDto;
import com.example.deparments.entities.Product;
import com.example.deparments.exceptions.ResourceNotFoundException;
import com.example.deparments.services.IProductService;
import com.example.deparments.services.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private ProductServiceImp productService;

    @GetMapping
    public ResponseEntity<List<ProductGetDto>> getProducts() {
        List<Product> products = productService.getProducts();
        List<ProductGetDto> productsDto = productService.convertProductsToProductsDto(products);
        return ResponseEntity.ok( productsDto );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductGetDto> getProductById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        ProductGetDto productDto = productService.convertProductToProductDto(product);
        return ResponseEntity.ok( productDto );
    }

    @GetMapping("/titulo")
    public ResponseEntity<Product> getProductByName(@RequestParam String title)
            throws ResourceNotFoundException {
        Optional<Product> product = productService.getProductByTitle(title);
        if ( product.isPresent() ) {
            return ResponseEntity.ok( product.get() );
        } else {
            throw new ResourceNotFoundException("There is not any product with the specified name");
        }
    }
    @GetMapping("/reserva")
    public ResponseEntity<List<ProductGetDto>> getProductsBetweenTwoDates(@RequestParam String firstDate, @RequestParam String lastDate)
            throws ParseException {
        List<Product> products = productService.getProductsBetweenTwoDates(firstDate, lastDate);
        List<ProductGetDto> productsDto = productService.convertProductsToProductsDto(products);
        return ResponseEntity.ok( productsDto );
    }
    @GetMapping("/categoria/{categoryId}")
    public ResponseEntity<List<ProductGetDto>> getProductsByCategoryId(@PathVariable("categoryId") Long categoryId) {
        List<Product> products = productService.getProductsByCategoryId(categoryId);
        List<ProductGetDto> productsDto = productService.convertProductsToProductsDto(products);
        return ResponseEntity.ok( productsDto );
    }
    @GetMapping("/ciudad/{cityId}")
    public ResponseEntity<List<ProductGetDto>> getProductsByCityId(@PathVariable("cityId") Long cityId) {
        List<Product> products = productService.getProductsByCityId(cityId);
        List<ProductGetDto> productsDto = productService.convertProductsToProductsDto(products);
        return ResponseEntity.ok( productsDto );
    }
    @PostMapping
    public ResponseEntity<ProductGetDto> saveProduct(@RequestBody ProductPostDto productPostDto) {
        Product product = productService.saveProduct(productPostDto);
        ProductGetDto productGetDto = productService.convertProductToProductDto(product);
        return new ResponseEntity<>(productGetDto, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<String> updateProduct(@RequestBody ProductPostDto productPostDto) {
        Product product = productService.updateProduct(productPostDto);
        return new ResponseEntity<String>("The product with ID " + product.getId() +
                                                " has been updated successfully", HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<String>("The product with ID " + id +
                                                " has been deleted successfully", HttpStatus.OK);
    }

}
