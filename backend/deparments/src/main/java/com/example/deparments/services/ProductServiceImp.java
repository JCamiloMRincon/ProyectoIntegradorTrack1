package com.example.deparments.services;
import com.example.deparments.dto.*;
import com.example.deparments.entities.*;
import com.example.deparments.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ProductServiceImp implements IProductService {

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IImageRepository imageRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private ICityRepository cityRepository;
    @Autowired
    private IFeatureRepository featureRepository;
    @Autowired
    private IPolicyRepository policyRepository;
    @Autowired
    private IPolicyTypeRepository policyTypeRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if( product.isPresent() ) {
            return product.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "The product with id " + id + " does not exist");
        }
    }

    @Override
    public Optional<Product> getProductByTitle(String title) {
        return productRepository.findByTitulo(title);
    }

    @Override
    public List<Product> getProductsBetweenTwoDates(String firstDate, String lastDate)
            throws ParseException {
        try {
            Date firstDateConverted = new SimpleDateFormat("yyyy-MM-dd").parse(firstDate);
            Date lastDateConverted = new SimpleDateFormat("yyyy-MM-dd").parse(lastDate);
            return productRepository.findBetweenTwoDates(firstDateConverted, lastDateConverted);
        } catch (ParseException parseEx) {
            return null;
        }
    }

    @Override
    public List<Product> getProductsByCityId(Long cityId) {
        return productRepository.findByCityId(cityId);
    }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public Product saveProduct(ProductPostDto productDto) {

            Product product = convertProductDtoToProduct( productDto );
            Product productSaved = productRepository.save(product);
            Set<ImagePostDto> images = productDto.getImagenes();

            for (ImagePostDto imageDto : images) {
                Image image = convertImageDtoToImage(imageDto, productSaved);
                image.setProducto(productSaved);
                imageRepository.save(image);
            }

            return productSaved;
    }

    @Override
    public Product updateProduct(ProductPostDto productDto) {
        try {
            getProductById( productDto.getId() );
            Product product = convertProductDtoToProduct( productDto );
            return productRepository.save( product );
        } catch (ResponseStatusException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public void deleteProduct(Long id) {
        try {
            getProductById( id );
            productRepository.deleteById( id );
        } catch (ResponseStatusException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Feature convertFeatureDtoToFeature(FeaturePostDto featureDto) {
        Feature feature = new Feature();

        if( featureDto.getId() != null ) {
            feature = featureRepository.findById( featureDto.getId() ).get();
        } else {
            feature.setNombre( featureDto.getNombre() );
            feature.setUrlicono( featureDto.getUrlicono() );
        }

        return feature;
    }
    public Image convertImageDtoToImage(ImagePostDto imageDto, Product product) {
        Image image = new Image();

        if ( imageDto.getId() != null ) {
            image.setId( imageDto.getId() );
        }

        image.setTitulo( product.getCategoria().getTitulo() + "_Imagen_Producto_" + product.getId() );
        image.setUrl( imageDto.getUrl() );

        return image;
    }
    public Policy convertPolicyDtoToPolicy(PolicyPostDto policyDto) {
        Policy policy = new Policy();

        if( policyDto.getId() != null ) {
            policy = policyRepository.findById( policyDto.getId() ).get();
        } else {
            policy.setNombre( policyDto.getNombre() );
            policy.setTipo( policyTypeRepository.findById( policyDto.getTipoPoliticaId() ).get() );
        }

        return policy;
    }
    public ProductGetDto convertProductToProductDto(Product product) {
        ProductGetDto productDto = new ProductGetDto();
        List<Image> images = imageRepository.findByProductId(product.getId());
        List<ImageGetDto> imagesDto = new ArrayList<>();

        for (int i = 0; i < images.size(); i++) {
            Image image = images.get(i);
            ImageGetDto imageDto = new ImageGetDto();

            imageDto.setId( image.getId() );
            imageDto.setTitulo( image.getTitulo() );
            imageDto.setUrl( image.getUrl() );

            imagesDto.add( imageDto );
        }

        productDto.setId( product.getId() );
        productDto.setTitulo( product.getTitulo() );
        productDto.setCategoria( product.getCategoria() );
        productDto.setDireccion( product.getDireccion() );
        productDto.setCiudad( product.getCiudad() );
        productDto.setDescripcion( product.getDescripcion() );
        productDto.setCaracteristicas( product.getCaracteristicas() );
        productDto.setDisponible( product.isDisponible() );
        productDto.setPoliticas(product.getPoliticas() );
        productDto.setImagenes( imagesDto );

        return productDto;
    }

    public Product convertProductDtoToProduct(ProductPostDto productDto) {

        Product product = new Product();

        Category category = categoryRepository.findById(productDto.getCategoriaId()).get();
        City city = cityRepository.findById(productDto.getCiudadId()).get();
        Set<Feature> features = new HashSet<>();
        Set<Policy> policies = new HashSet<>();

        if( productDto.getId() != null ) {
            product.setId( productDto.getId() );
        }

        product.setTitulo( productDto.getTitulo() );
        product.setDireccion( productDto.getDireccion() );
        product.setDescripcion( productDto.getDescripcion() );
        product.setDisponible( productDto.isDisponible() );
        product.setCategoria( category );
        product.setCiudad( city );

        for ( FeaturePostDto featureDto : productDto.getCaracteristicas() ) {
            Feature feature = convertFeatureDtoToFeature(featureDto);
            features.add(feature);
        }

       for ( PolicyPostDto policyDto : productDto.getPoliticas() ) {
           Policy policy = convertPolicyDtoToPolicy(policyDto);
           policies.add(policy);
       }

        product.setCaracteristicas( features );
        product.setPoliticas( policies );

        return product;
    }
    public List<ProductGetDto> convertProductsToProductsDto(List<Product> products) {

        List<ProductGetDto> productsDto = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            ProductGetDto productDto = new ProductGetDto();

            List<Image> images = imageRepository.findByProductId(product.getId());
            List<ImageGetDto> imagesDto = new ArrayList<>();

            for (int j = 0; j < images.size(); j++) {
                Image image = images.get(j);
                ImageGetDto imageDto = new ImageGetDto();

                imageDto.setId( image.getId() );
                imageDto.setTitulo( image.getTitulo() );
                imageDto.setUrl( image.getUrl() );

                imagesDto.add( imageDto );
            }

            productDto.setId( product.getId() );
            productDto.setTitulo( product.getTitulo() );
            productDto.setCategoria( product.getCategoria() );
            productDto.setDireccion( product.getDireccion() );
            productDto.setCiudad( product.getCiudad() );
            productDto.setDescripcion( product.getDescripcion() );
            productDto.setCaracteristicas( product.getCaracteristicas() );
            productDto.setDisponible( product.isDisponible() );
            productDto.setPoliticas(product.getPoliticas() );
            productDto.setImagenes( imagesDto );

            productsDto.add(productDto);
        }

        return productsDto;
    }
}
