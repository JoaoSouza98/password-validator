package com.itidigital.passwordvalidator.domain

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AtLeastOneSpecialCharValidatorTest {

    private val atLeastOneSpecialCharValidator = AtLeastOneSpecialCharValidator(specialCharSet = "!@#\$%^&*()-+")

    @Test
    fun `given an input string when it ends with a special char should return true`() {

        //arrange
        val input = "ABC4%21a)"

        //act
        val result = atLeastOneSpecialCharValidator.meetsRequirement(input)

        //assert
        assertTrue(result)
    }

    @Test
    fun `given an input string when it starts with a special char should return true`() {

        //arrange
        val input = "+nABC4%21"

        //act
        val result = atLeastOneSpecialCharValidator.meetsRequirement(input)

        //assert
        assertTrue(result)
    }

    @Test
    fun `given an input string when it contains a special char should return true`() {

        //arrange
        val input = "ABCt\$4u21"

        //act
        val result = atLeastOneSpecialCharValidator.meetsRequirement(input)

        //assert
        assertTrue(result)
    }

    @Test
    fun `given an input string when it doesn't contains a special char should return false`() {

        //arrange
        val input = "ABC4f21"

        //act
        val result = atLeastOneSpecialCharValidator.meetsRequirement(input)

        //assert
        assertFalse(result)
    }
}