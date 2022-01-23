package com.itidigital.passwordvalidator.application.config.passwordvalidator

import com.itidigital.passwordvalidator.domain.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PasswordValidatorsConfig(private val props: PasswordValidatorsProps) {

    @Bean
    fun configureValidators(): PasswordValidator {

        val atLeastOneDigitValidator = AtLeastOneDigitValidator()
        val atLeastOneLowerCaseValidator = AtLeastOneLowerCaseValidator(atLeastOneDigitValidator)
        val atLeastOneSpecialCharValidator = AtLeastOneSpecialCharValidator(
            props.specialCharSet,
            atLeastOneLowerCaseValidator
        )
        val atLeastOneUpperCaseValidator = AtLeastOneUpperCaseValidator(atLeastOneSpecialCharValidator)
        val lengthValidator = LengthValidator(props.requiredLength, atLeastOneUpperCaseValidator)
        val noRepeatValidator = NoRepeatValidator(lengthValidator)

        return NoWhitespacesValidator(noRepeatValidator)
    }
}