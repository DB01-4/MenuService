package com.example.menuservice.dishes

import com.example.menuservice.model.Product
import com.example.menuservice.repo.ProductRepo
import com.example.menuservice.service.ProductService
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class DishesUnitTests {
    @Mock
    private val productRepository: ProductRepo? = null
    private var autoCloseable: AutoCloseable? = null
    private var underTest: ProductService? = null

    //before start of every test
    @BeforeEach
    fun setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this)
        underTest = ProductService(productRepository!!)
    }

    //end of every test
    @AfterEach
    @Throws(Exception::class)
    fun tearDown() {
        autoCloseable!!.close()
    }


/*    @Test
    fun saveProduct() {
        val prod = Product()
        //when
        underTest!!.saveProduct(prod)
        //then
        Mockito.verify(productRepository)?.save(prod)
    }*/


    //when
    //then
    @Test
    fun products() {
            //when
            underTest!!.products
            //then
            Mockito.verify(productRepository)?.findAll()
        }


/*    @Test
    fun productById() {
            //when
            underTest!!.getProductById(1)
            //then
            Mockito.verify(productRepository)?.findById(1)
        }*/


    @Test
    fun deleteProduct() {
        //when
        underTest!!.deleteProduct(1)
        //then
        Mockito.verify(productRepository)?.deleteById(1)
    }
}
