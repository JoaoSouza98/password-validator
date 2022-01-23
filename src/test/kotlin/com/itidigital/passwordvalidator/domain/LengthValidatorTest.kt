package com.itidigital.passwordvalidator.domain

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LengthValidatorTest {

    private val lengthValidator = LengthValidator(6)

    @Test
    fun `given an input string when is equal the specified should return true`() {

        //arrange
        val input = "abc4%2"

        //act
        val result = lengthValidator.meetsRequirement(input)

        //assert
        assertTrue(result)
    }

    @Test
    fun `given an input string when is greater than the specified should return true`() {

        //arrange
        val input = "NnABC4%21"

        //act
        val result = lengthValidator.meetsRequirement(input)

        //assert
        assertTrue(result)
    }

    @Test
    fun `given an input string when is lower than the specified should return false`() {

        //arrange
        val input = "abCt4"

        //act
        val result = lengthValidator.meetsRequirement(input)

        //assert
        assertFalse(result)
    }
}