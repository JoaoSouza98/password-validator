package com.itidigital.passwordvalidator.commons.ext

fun String.matches(pattern: String) = this.matches(Regex(pattern))