package com.example.sample

import org.junit.Assert.assertFalse
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ValidatorUnitTest {

    val validator = Validator()

    @Test
    fun inValidUserNameTest() {
        val result = validator.isValidUserName("testusername%#")
        assertFalse(result)
    }

    @Test
    fun inValidPasswordTest() {
        val result = validator.isValidPassword("testpassword123")
        assertFalse(result)
    }



}