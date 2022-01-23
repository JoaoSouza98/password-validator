package com.itidigital.passwordvalidator.application.web.responses

import com.fasterxml.jackson.annotation.JsonProperty

class PasswordValidationResponse(@get:JsonProperty("is_valid") val isValid: Boolean)