package com.itidigital.passwordvalidator.domain

import com.itidigital.passwordvalidator.commons.ext.matches

class AtLeastOneSpecialCharValidator(
    private val specialCharSet: String,
    override val decoratedValidator: PasswordValidator? = null
): PasswordValidator {

    override fun meetsRequirement(password: String) = password.matches(".*[$specialCharSet]+.*")
}