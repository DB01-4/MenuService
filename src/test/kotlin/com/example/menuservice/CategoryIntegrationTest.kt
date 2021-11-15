package com.example.menuservice

import com.example.menuservice.model.Category
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
class CategoryIntegrationTest(@Autowired val testRestTemplate: TestRestTemplate) {

    lateinit var getCategoryUrl: String
    lateinit var categoryUrl: String
    lateinit var headers: HttpHeaders
    lateinit var categoryPostObject: JSONObject
    lateinit var categoryPutObject: JSONObject
    var categoryId: Int? = null

    @BeforeAll
    fun setup () {
        getCategoryUrl = "/categories/"
        categoryUrl = "/categories/"
        headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        categoryPutObject = JSONObject()
        categoryPutObject["name"] = "Doe"
        categoryPutObject["description"] = "John"

        categoryPostObject = JSONObject()
        categoryPostObject["name"] = "John"
        categoryPostObject["description"] = "Doe"
    }

    @Test
    fun testCategoryControllerGetById() {
        val result = testRestTemplate.getForEntity(getCategoryUrl+"1", Category::class.java)
        Assertions.assertNotNull(result)
        Assertions.assertEquals(result.statusCode, HttpStatus.OK)
    }

    @Test
    fun testCategoryControllerPost() {

        val request = HttpEntity<String>(categoryPostObject.toString(), headers)

        val category: Category = testRestTemplate.postForObject(categoryUrl, request, Category::class.java)

        Assertions.assertNotNull(category)
        Assertions.assertNotNull(category.id)
        categoryId = category.id
        Assertions.assertNotNull(category.name)
        Assertions.assertNotNull(category.description)
        Assertions.assertEquals(categoryPostObject["name"], category.name)
        Assertions.assertEquals(categoryPostObject["description"], category.description)

        testRestTemplate.delete(categoryUrl+categoryId.toString())

    }

    @Test
    fun testCategoryControllerPut() {

        var request = HttpEntity<String>(categoryPostObject.toString(), headers)

        val postCategory: Category = testRestTemplate.postForObject(categoryUrl, request, Category::class.java)

        Assertions.assertNotNull(postCategory)
        Assertions.assertNotNull(postCategory.id)
        categoryId = postCategory.id

        request = HttpEntity<String>(categoryPutObject.toString(), headers)

        val result = testRestTemplate.put(categoryUrl+categoryId.toString(), request)

        Assertions.assertNotNull(result)

        val category: Category = testRestTemplate.getForObject(getCategoryUrl+categoryId.toString(), Category::class.java)

        Assertions.assertEquals(categoryPutObject["name"], category.name)
        Assertions.assertEquals(categoryPutObject["description"], category.description)

        testRestTemplate.delete(categoryUrl+categoryId.toString())
    }

    @Test
    fun testCategoryControllerDelete() {
        // testRestTemplate.delete(categoryUrl+categoryId.toString())

        val result = testRestTemplate.getForEntity(getCategoryUrl+"10", Category::class.java)
        Assertions.assertNotNull(result)
        Assertions.assertEquals(result.statusCode, HttpStatus.OK)
    }

}