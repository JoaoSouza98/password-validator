package com.itidigital.passwordvalidator.application.config.passwordvalidator

import kotlin.properties.Delegates

class PasswordValidatorsProps {

    var requiredLength by Delegates.notNull<Int>()
    lateinit var specialCharSet: String
}