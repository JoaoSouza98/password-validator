package com.itidigital.passwordvalidator.domain

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AtLeastOneDigitValidatorTest {

    private val validator = AtLeastOneDigitValidator()

    @Test
    fun `given an input string when it ends with a number should return true`(){

        val input = "ab c123"


        val result = validator.meetsRequirement(input)


        assertTrue(result)
    }

    @Test
    fun `given an input string when it starts with a number should return true`(){

        val input = "12ab\$c"


        val result = validator.meetsRequirement(input)


        assertTrue(result)
    }

    @Test
    fun `given an input string when it contains a number should return true`(){

        val input = "ab2c"


        val result = validator.meetsRequirement(input)


        assertTrue(result)
    }

    @Test
    fun `given an input string when it doesn't contains a number should return false`(){

        val input = "ab c "


        val result = validator.meetsRequirement(input)


        assertFalse(result)
    }
}