package com.itidigital.passwordvalidator.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AtLeastOneUpperCaseValidatorTest {

    private val atLeastOneUpperCaseValidator = AtLeastOneUpperCaseValidator()

    @Test
    fun `given an input string when it ends with a upper case char should return true`() {

        //arrange
        val input = "abc4%21aBB"

        //act
        val result = atLeastOneUpperCaseValidator.meetsRequirement(input)

        //assert
        Assertions.assertTrue(result)
    }

    @Test
    fun `given an input string when it starts with a upper case char should return true`() {

        //arrange
        val input = "NnABC4%21"

        //act
        val result = atLeastOneUpperCaseValidator.meetsRequirement(input)

        //assert
        Assertions.assertTrue(result)
    }

    @Test
    fun `given an input string when it contains a upper case char should return true`() {

        //arrange
        val input = "abCt4%u21"

        //act
        val result = atLeastOneUpperCaseValidator.meetsRequirement(input)

        //assert
        Assertions.assertTrue(result)
    }

    @Test
    fun `given an input string when it doesn't contains a upper case char should return false`() {

        //arrange
        val input = "abc4%21"

        //act
        val result = atLeastOneUpperCaseValidator.meetsRequirement(input)

        //assert
        Assertions.assertFalse(result)
    }
}