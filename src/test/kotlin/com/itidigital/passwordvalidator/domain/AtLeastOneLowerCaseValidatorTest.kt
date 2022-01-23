package com.itidigital.passwordvalidator.domain

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AtLeastOneLowerCaseValidatorTest {

    private val atLeastOneLowerCaseValidator = AtLeastOneLowerCaseValidator()

    @Test
    fun `given an input string when it ends with a lower case char should return true`() {

        //arrange
        val input = "ABC4%21a"

        //act
        val result = atLeastOneLowerCaseValidator.meetsRequirement(input)

        //assert
        assertTrue(result)
    }

    @Test
    fun `given an input string when it starts with a lower case char should return true`() {

        //arrange
        val input = "nABC4%21"

        //act
        val result = atLeastOneLowerCaseValidator.meetsRequirement(input)

        //assert
        assertTrue(result)
    }

    @Test
    fun `given an input string when it contains a lower case char should return true`() {

        //arrange
        val input = "ABCt4%u21"

        //act
        val result = atLeastOneLowerCaseValidator.meetsRequirement(input)

        //assert
        assertTrue(result)
    }

    @Test
    fun `given an input string when it doesn't contains a lower case char should return false`() {

        //arrange
        val input = "ABC4%21"

        //act
        val result = atLeastOneLowerCaseValidator.meetsRequirement(input)

        //assert
        assertFalse(result)
    }
}