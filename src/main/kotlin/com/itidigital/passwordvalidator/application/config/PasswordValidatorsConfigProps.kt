package com.itidigital.passwordvalidator.application.config

import kotlin.properties.Delegates

class PasswordValidatorsConfigProps {

    var requiredLength by Delegates.notNull<Int>()
    lateinit var specialCharSet: String
}