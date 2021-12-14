package com.example.menuservice

import com.example.menuservice.model.Product
import net.minidev.json.JSONObject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DishesIntegrationTest(@Autowired val testRestTemplate: TestRestTemplate) {

    lateinit var getProductUrl: String
    lateinit var productUrl: String
    lateinit var headers: HttpHeaders
    lateinit var productPostObject: JSONObject
    lateinit var productPutObject: JSONObject
    var productId: Int? = null

    @BeforeAll
    fun setup () {
        getProductUrl = "/products/"
        productUrl = "/products/"
        headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        productPutObject = JSONObject()
        productPutObject["name"] = "John"
        productPutObject["description"] = "Doe"
        productPutObject["image"] = "newImage"

        productPostObject = JSONObject()
        productPostObject["name"] = "Doe"
        productPostObject["description"] = "John"
        productPostObject["image"] = "image"
    }

    @Test
    fun testProductControllerGetById() {
        val result = testRestTemplate.getForEntity(getProductUrl+"1", Product::class.java)
        Assertions.assertNotNull(result)
        Assertions.assertEquals(result.statusCode, HttpStatus.OK)
    }

    @Test
    fun testProductControllerPost() {

        val request = HttpEntity<String>(productPostObject.toString(), headers)

        val product: Product = testRestTemplate.postForObject(productUrl, request, Product::class.java)

        Assertions.assertNotNull(product)
        Assertions.assertNotNull(product.id)
        productId = product.id
        Assertions.assertNotNull(product.name)
        Assertions.assertNotNull(product.description)
        Assertions.assertEquals(productPostObject["name"], product.name)
        Assertions.assertEquals(productPostObject["description"], product.description)
        Assertions.assertEquals(productPostObject["image"], product.image)

        testRestTemplate.delete(productUrl+productId.toString())

    }

    @Test
    fun testProductControllerPut() {

        var request = HttpEntity<String>(productPostObject.toString(), headers)

        val postProduct: Product = testRestTemplate.postForObject(productUrl, request, Product::class.java)

        Assertions.assertNotNull(postProduct)
        Assertions.assertNotNull(postProduct.id)
        productId = postProduct.id

        request = HttpEntity<String>(productPutObject.toString(), headers)

        val result = testRestTemplate.put(productUrl+productId.toString(), request)

        Assertions.assertNotNull(result)

        val product: Product = testRestTemplate.getForObject(getProductUrl+productId.toString(), Product::class.java)

        Assertions.assertEquals(productPostObject["name"], product.name)
        Assertions.assertEquals(productPostObject["description"], product.description)
        Assertions.assertEquals(productPostObject["image"], product.image)

        testRestTemplate.delete(productUrl+productId.toString())
    }

    @Test
    fun testProductControllerDelete() {
        // testRestTemplate.delete(product+productId.toString())

        val result = testRestTemplate.getForEntity(getProductUrl+"10", Product::class.java)
        Assertions.assertNotNull(result)
        Assertions.assertEquals(result.statusCode, HttpStatus.OK)
    }
}