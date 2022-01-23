package com.itidigital.passwordvalidator.application.web.controllers

import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

class PasswordValidatorControllerIntegrationTest: BaseRestIntegrationTest() {

    @Test
    fun `when a blank password is informed should return 200 with is_valid false`() {

        Given {
            spec(requestSpecification)
            basePath("/validate")
            body(buildRequest(""))
        } When {
             post()
         } Then {
            statusCode(200)
            body("is_valid", `is`(false))
         }
    }

    @Test
    fun `when a password composed by a duplication is informed should return 200 with is_valid false`() {

        Given {
            spec(requestSpecification)
            basePath("/validate")
            body(buildRequest("aa"))
        } When {
             post()
         } Then {
            statusCode(200)
            body("is_valid", `is`(false))
         }
    }

    @Test
    fun `when a password composed by two alphabetical lower case chars is informed should return 200 with is_valid false`() {

        Given {
            spec(requestSpecification)
            basePath("/validate")
            body(buildRequest("ab"))
        } When {
             post()
         } Then {
            statusCode(200)
            body("is_valid", `is`(false))
         }
    }

    @Test
    fun `when a password with no special chars and with lenght lower than the expected is informed should return 200 with is_valid false`() {

        Given {
            spec(requestSpecification)
            basePath("/validate")
            body(buildRequest("AAAbbbCc"))
        } When {
             post()
         } Then {
            statusCode(200)
            body("is_valid", `is`(false))
         }
    }

    @Test
    fun `when a password that ends with a repetition is informed should return 200 with is_valid false`() {

        Given {
            spec(requestSpecification)
            basePath("/validate")
            body(buildRequest("AbTp9!foo"))
        } When {
             post()
         } Then {
            statusCode(200)
            body("is_valid", `is`(false))
         }
    }

    @Test
    fun `when a password that starts and ends with the same char and case is informed should return 200 with is_valid false`() {

        Given {
            spec(requestSpecification)
            basePath("/validate")
            body(buildRequest("AbTp9!foA"))
        } When {
             post()
         } Then {
            statusCode(200)
            body("is_valid", `is`(false))
         }
    }

    @Test
    fun `when a password that contains a whitespace is informed should return 200 with is_valid false`() {

        Given {
            spec(requestSpecification)
            basePath("/validate")
            body(buildRequest("AbTp9 fok"))
        } When {
             post()
         } Then {
            statusCode(200)
            body("is_valid", `is`(false))
         }
    }
    
    @Test
    fun `when a password that meet all the requirements is informed should return 200 with is_valid true`() {

        Given {
            spec(requestSpecification)
            basePath("/validate")
            body(buildRequest("AbTp9!fok"))
        } When {
             post()
         } Then {
            statusCode(200)
            body("is_valid", `is`(true))
         }
    }

    @Test
    fun `when password field are not informed should return 400`() {

        Given {
            spec(requestSpecification)
            basePath("/validate")
            body("""
            {
                "passwordd": "AbTp9!fok"
            }
            """.trimIndent())
        } When {
             post()
         } Then {
            statusCode(400)
            body("type", equalTo("INVALID_PAYLOAD"))
            body("message", equalTo("Message not readable"))
         }
    }

    @Test
    fun `when a password that meet all the requirements and an additional unknown field are informed should return 200 with is_valid true`() {

        Given {
            spec(requestSpecification)
            basePath("/validate")
            body("""
            {
                "password": "AbTp9!fok",
                "some_field": "some value"
            }
            """.trimIndent())
        } When {
             post()
         } Then {
            statusCode(200)
            body("is_valid", `is`(true))
         }
    }

    private fun buildRequest(password: String) = """
            {
                "password": "$password"
            }
            """.trimIndent()
}