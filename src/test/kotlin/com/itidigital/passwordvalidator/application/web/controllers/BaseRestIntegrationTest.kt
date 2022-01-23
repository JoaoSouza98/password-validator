package com.itidigital.passwordvalidator.application.web.controllers

import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class BaseRestIntegrationTest {

    @LocalServerPort
    private var port: Int? = null

    protected lateinit var requestSpecification: RequestSpecification

    @BeforeAll
    fun setup() {

        requestSpecification = RequestSpecBuilder()
            .setPort(port!!)
            .setContentType(ContentType.JSON)
            .build()
    }
}