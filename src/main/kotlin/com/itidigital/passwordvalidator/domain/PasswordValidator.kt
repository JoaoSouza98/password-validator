package com.itidigital.passwordvalidator.domain

interface PasswordValidator {

    val decoratedValidator: PasswordValidator?
    
    fun meetsRequirement(password: String): Boolean

    fun isValid(password: String):Boolean = meetsRequirement(password).and(decoratedValidator?.isValid(password) ?: true)
}