package com.itidigital.passwordvalidator.domain

import com.itidigital.passwordvalidator.commons.ext.matches

class AtLeastOneDigitValidator(override val decoratedValidator: PasswordValidator? = null) : PasswordValidator {

    override fun meetsRequirement(password: String) = password.matches(".*[0-9]+.*")
}