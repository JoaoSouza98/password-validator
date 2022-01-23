package com.itidigital.passwordvalidator.domain

class NoWhitespacesValidator(override val decoratedValidator: PasswordValidator? = null) : PasswordValidator {

    override fun meetsRequirement(password: String) = !password.contains(" ")
}