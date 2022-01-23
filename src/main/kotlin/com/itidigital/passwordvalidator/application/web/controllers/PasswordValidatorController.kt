package com.itidigital.passwordvalidator.application.web.controllers

import com.itidigital.passwordvalidator.application.web.exceptionhandlers.ApiError
import com.itidigital.passwordvalidator.application.web.requests.PasswordValidationRequest
import com.itidigital.passwordvalidator.application.web.responses.PasswordValidationResponse
import com.itidigital.passwordvalidator.domain.PasswordValidator
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class PasswordValidatorController(private val passwordValidator: PasswordValidator) {

    @Tag(name = "Validator")
    @PostMapping("/validate")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "password successfully analyzed!"),
        ApiResponse(responseCode = "400", description = "malformed payload", content = arrayOf(
            Content(schema = Schema(implementation = ApiError::class))
        ))
        ]
    )
    fun isValid(@RequestBody @Valid data: PasswordValidationRequest) = PasswordValidationResponse(
        passwordValidator.isValid(data.password)
    )
}