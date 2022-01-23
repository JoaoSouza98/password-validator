package com.itidigital.passwordvalidator.domain

class NoRepeatValidator(override val decoratedValidator: PasswordValidator? = null) : PasswordValidator {

    override fun meetsRequirement(password: String) = password.length == password.chars().distinct().count().toInt()
}