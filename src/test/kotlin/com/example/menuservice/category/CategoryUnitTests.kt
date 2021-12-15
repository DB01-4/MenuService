package com.example.menuservice.category

import com.example.menuservice.model.Category
import com.example.menuservice.repo.CategoryRepo
import com.example.menuservice.service.CategoryService
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class CategoryUnitTests {
    @Mock
    private val categoryRepo: CategoryRepo? = null
    private var autoCloseable: AutoCloseable? = null
    private var underTest: CategoryService? = null

    //before start of every test
    @BeforeEach
    fun setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this)
        underTest = CategoryService(categoryRepo!!)
    }

    //end of every test
    @AfterEach
    @Throws(Exception::class)
    fun tearDown() {
        autoCloseable!!.close()
    }

    @Test
    fun saveCategory() {
        val cat = Category()
        //when
        underTest!!.saveCategory(cat)
        //then
        Mockito.verify(categoryRepo)?.save(cat)
    }

    //when
    //then
    @Test
    fun getCategories() {
            //when
            underTest!!.categories
            //then
            Mockito.verify(categoryRepo)?.findAll()
        }

    @Test
    fun categoryById() {
            //when
            underTest!!.getCategoryById(1)
            //then
            Mockito.verify(categoryRepo)?.findById(1)
        }

    @Test
    fun deleteProduct() {
        //when
        underTest!!.deleteCategory(1)
        //then
        Mockito.verify(categoryRepo)?.deleteById(1)
    }
}
