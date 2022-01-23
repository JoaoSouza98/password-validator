package com.itidigital.passwordvalidator.domain

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class NoRepeatValidatorTest {

    private val noRepeatValidator = NoRepeatValidator()

    @Test
    fun `given an input string when it ends with a repetition should return false`() {

        //arrange
        val input = "abc4%21aBB"

        //act
        val result = noRepeatValidator.meetsRequirement(input)

        //assert
        assertFalse(result)
    }

    @Test
    fun `given an input string when it starts with a repetition should return false`() {

        //arrange
        val input = "vvNnABC4%21"

        //act
        val result = noRepeatValidator.meetsRequirement(input)

        //assert
        assertFalse(result)
    }

    @Test
    fun `given an input string when it contains a repetition should return false`() {

        //arrange
        val input = "abCt4%%u21"

        //act
        val result = noRepeatValidator.meetsRequirement(input)

        //assert
        assertFalse(result)
    }

    @Test
    fun `given an input string when it doesn't contains a repetition should return true`() {

        //arrange
        val input = "abcC4%21"

        //act
        val result = noRepeatValidator.meetsRequirement(input)

        //assert
        assertTrue(result)
    }
}