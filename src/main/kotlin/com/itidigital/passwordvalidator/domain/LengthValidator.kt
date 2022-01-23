package com.itidigital.passwordvalidator.domain

class LengthValidator(
    private val requiredLength: Int,
    override val decoratedValidator: PasswordValidator? = null
): PasswordValidator {

    override fun meetsRequirement(password: String) = password.length >= requiredLength
}