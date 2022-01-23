package com.itidigital.passwordvalidator.application.web.exceptionhandlers

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ApiExceptionHandler: ResponseEntityExceptionHandler() {

    override fun handleHttpMessageNotReadable(
        ex: HttpMessageNotReadableException,
        headers: HttpHeaders, status: HttpStatus, request: WebRequest
    ): ResponseEntity<Any> {

        val message = "Message not readable"
        val detail = "The request body is not readable. Please, check for syntax issues and if all the mandatory " +
                "fields where informed"
        val error = ApiError(ApiErrorType.INVALID_PAYLOAD, message, listOf(detail))

        return handleExceptionInternal(ex, error, headers, status, request)
    }
}