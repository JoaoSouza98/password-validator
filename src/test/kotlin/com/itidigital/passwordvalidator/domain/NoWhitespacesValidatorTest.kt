package com.itidigital.passwordvalidator.domain

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class NoWhitespacesValidatorTest {

    private val noWhitespacesValidator = NoWhitespacesValidator()

    @Test
    fun `given an input string when it ends with a whitespace should return false`() {

        //arrange
        val input = "abc4%21aBB  "

        //act
        val result = noWhitespacesValidator.meetsRequirement(input)

        //assert
        assertFalse(result)
    }

    @Test
    fun `given an input string when it starts with a whitespace should return false`() {

        //arrange
        val input = " vvNnABC4%21"

        //act
        val result = noWhitespacesValidator.meetsRequirement(input)

        //assert
        assertFalse(result)
    }

    @Test
    fun `given an input string when it contains a whitespace should return false`() {

        //arrange
        val input = "abC t4% %u21"

        //act
        val result = noWhitespacesValidator.meetsRequirement(input)

        //assert
        assertFalse(result)
    }

    @Test
    fun `given an input string when it doesn't contains a whitespace should return true`() {

        //arrange
        val input = "abcC4%21"

        //act
        val result = noWhitespacesValidator.meetsRequirement(input)

        //assert
        assertTrue(result)
    }
}