package com.itidigital.passwordvalidator.application.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PropertiesConfig {

    @Bean
    @ConfigurationProperties("password-validators")
    fun validatorsProps() = PasswordValidatorsConfigProps()
}