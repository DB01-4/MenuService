package com.example.menuservice;

import com.example.menuservice.model.Category;
import com.example.menuservice.model.Product;
import com.example.menuservice.repo.CategoryRepo;
import com.example.menuservice.repo.ProductRepo;
import com.example.menuservice.service.CategoryService;
import com.example.menuservice.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.mockito.Mockito.verify;

@DataJpaTest
public class CategoryUnitTests {

    @Mock
    private CategoryRepo categoryRepo;
    private AutoCloseable autoCloseable;
    private CategoryService underTest;

    //before start of every test
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CategoryService(categoryRepo);
    }

    //end of every test
    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void saveCategory() {

        Category cat = new Category();
        //when
        underTest.saveCategory(cat);
        //then
        verify(categoryRepo).save(cat);
    }

    @Test
    void getCategory() {
        //when
        underTest.getCategories();
        //then
        verify(categoryRepo).findAll();
    }

    @Test
    void getCategoryById() {
        //when
        underTest.getCategoryById(1);
        //then
        verify(categoryRepo).findById(1);
    }

    @Test
    void deleteProduct() {
        //when
        underTest.deleteCategory(1);
        //then
        verify(categoryRepo).deleteById(1);
    }
}
