package com.itidigital.passwordvalidator.application.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApiDocsConfig {

    @Bean
    public fun customOpenAPI() = OpenAPI()
        .components(Components())
        .info(
            Info().title("Password Validator")
                .description("Exposes password validation related operations")
                .version("1.0.0")
        )
}