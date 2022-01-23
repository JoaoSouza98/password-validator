package com.itidigital.passwordvalidator.domain

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AtLeastOneDigitValidatorTest {

    private val validator = AtLeastOneDigitValidator()

    @Test
    fun `given an input string when it ends with a number should return true`(){

        //arrange
        val input = "ab c123"

        //act
        val result = validator.meetsRequirement(input)

        //assert
        assertTrue(result)
    }

    @Test
    fun `given an input string when it starts with a number should return true`(){

        //arrange
        val input = "12ab\$c"

        //act
        val result = validator.meetsRequirement(input)

        //assert
        assertTrue(result)
    }

    @Test
    fun `given an input string when it contains a number should return true`(){

        //arrange
        val input = "ab2c"

        //act
        val result = validator.meetsRequirement(input)

        //assert
        assertTrue(result)
    }

    @Test
    fun `given an input string when it doesn't contains a number should return false`(){

        //arrange
        val input = "ab c "

        //act
        val result = validator.meetsRequirement(input)

        //assert
        assertFalse(result)
    }
}