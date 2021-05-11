package com.example.sample

class Validator {

    class TestData {
        companion object {
            fun getUserName(): String {
                return "testusername"
            }

            fun getPassword(): String {
                return "testPassword1"
            }
        }
    }

    // 4) Show error message in the username field if user enters invalid username
    fun isValidUserName(username: String?): Boolean {
        var valid: Boolean = true
        val userNameRegex = "^[a-zA-Z0-9]{8,16}\$".toRegex()
        if (!userNameRegex.matches(input = username!!)) {
            valid = false
        }
        return valid;
    }

    // 5) Show error message in the password field if user enters invalid password
    fun isValidPassword(password: String?): Boolean {
        val passwordRegex = "^(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,16}$".toRegex()
        var valid: Boolean = true
        if (!passwordRegex.matches(input = password!!)) {
            valid = false
        }
        return valid
    }


}