package com.itidigital.passwordvalidator.commons.ext

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StringExtensionTest {

    @Test
    fun `given a pattern to match and a string when it does match the pattern should return true`() {

        //arrange
        val regexString = ".*[0-9]+"
        val input = "Joao Antonio 23"

        //act
        val result = input.matches(regexString)
        val expected = input.matches(Regex(regexString))

        //assert
        assertTrue(result)
        assertEquals(expected, result)
    }

    @Test
    fun `given a pattern to match and a string when it doesn't match the pattern should return false`() {

        //arrange
        val regexString = ".*[0-9]+"
        val input = "Joao Antonio"

        //act
        val result = input.matches(regexString)
        val expected = input.matches(Regex(regexString))

        //assert
        assertFalse(result)
        assertEquals(expected, result)
    }
}