package com.example.deparments.services;

import com.example.deparments.entities.Category;
import com.example.deparments.entities.Product;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CategoryServiceTest {

    @Autowired
    ICategoryService categoryService;

    @Test
    @Order(1)
    void addCategoryTest() {
        Category categoryToBeAdded = new Category(
                "Habitación compartida",
                "Los huéspedes duermen en una habitación o área común que podrían compartir con otras personas",
                "habitacioncompartida.jpg",
                null);

        categoryService.saveCategory(categoryToBeAdded);
        List<Category> searchedCategory =
                categoryService.getCategoriesByTitle("Habitación compartida");

        assertTrue(searchedCategory.size() > 0);
    }

    @Test
    @Order(2)
    void getCategoryByIdTest() {
        Long idSearchedCategory =
                categoryService.getCategoriesByTitle("Habitación compartida").get(0).getId();

        Optional<Category> searchedCategory =
                categoryService.getCategoryById(idSearchedCategory);

        assertFalse(searchedCategory.isEmpty());
    }

    @Test
    @Order(3)
    void getCategoriesByTitleTest() {
        String titleSearchedCategory = "Habitación compartida";

        List<Category> searchedCategory =
                categoryService.getCategoriesByTitle(titleSearchedCategory);

        assertTrue(searchedCategory.size() > 0);
    }
    @Test
    @Order(4)
    void getCategoriesTest() {
        List<Category> testList =
                categoryService.getCategories();

        assertTrue(testList.size() > 0);
    }

    @Test
    @Order(5)
    void updateCategoryTest() {
        Category categoryWithNewData = new Category(
                categoryService.getCategoriesByTitle("Habitación compartida").get(0).getId(),
                "Habitación privada",
                "Los huéspedes duermen en una habitación o área común que no podrían compartir con otras personas",
                "habitacionprivada.jpg",
                null);

        categoryService.updateCategory(categoryWithNewData);
        Category searchedCategory =
                categoryService.getCategoriesByTitle("Habitación privada").get(0);

        assertEquals("Habitación privada", searchedCategory.getTitulo());
        assertEquals("Los huéspedes duermen en una habitación o área común que no podrían compartir con otras personas", searchedCategory.getDescripcion());
        assertEquals("habitacionprivada.jpg", searchedCategory.getURLImagen());
    }

    @Test
    @Order(6)
    void deleteCategoryTest() {
        Long idToBeDeleted =
                categoryService.getCategoriesByTitle("Habitación privada").get(0).getId();

        categoryService.deleteCategory(idToBeDeleted);
        Optional<Category> searchedCategory =
                categoryService.getCategoryById(idToBeDeleted);

        assertTrue(searchedCategory.isEmpty());
    }
}