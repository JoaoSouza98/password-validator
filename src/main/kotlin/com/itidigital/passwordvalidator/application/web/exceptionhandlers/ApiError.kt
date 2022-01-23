package com.itidigital.passwordvalidator.application.web.exceptionhandlers

class ApiError(
    val type: ApiErrorType,
    val message: String,
    val details: List<String>
)