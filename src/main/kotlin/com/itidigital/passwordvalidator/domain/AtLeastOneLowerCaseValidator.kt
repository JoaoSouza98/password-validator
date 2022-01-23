package com.itidigital.passwordvalidator.domain

import com.itidigital.passwordvalidator.commons.ext.matches

class AtLeastOneLowerCaseValidator(override val decoratedValidator: PasswordValidator? = null): PasswordValidator {

    override fun meetsRequirement(password: String) = password.matches(".*[a-z]+.*")
}