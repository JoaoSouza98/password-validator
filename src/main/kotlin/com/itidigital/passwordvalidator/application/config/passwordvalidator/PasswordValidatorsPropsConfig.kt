package com.itidigital.passwordvalidator.application.config.passwordvalidator

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PasswordValidatorsPropsConfig {

    @Bean
    @ConfigurationProperties("password-validators")
    fun validatorsProps() = PasswordValidatorsProps()
}