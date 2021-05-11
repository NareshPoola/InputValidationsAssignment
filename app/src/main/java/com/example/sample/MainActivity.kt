package com.example.sample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil.setContentView
import com.example.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var validator: Validator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_main)
        validator = Validator()
        var username = String()
        var password = String()

        binding.editTextTextUserName.doAfterTextChanged {
            username = it!!.toString()
            enableSubmitButton(username, password)
        }
        binding.editTextTextPassword.doAfterTextChanged {
            password = it!!.toString()
            enableSubmitButton(username, password)
        }

        binding.submitButton.setOnClickListener {
            if (!validator.isValidUserName(username)) {
                // 4) Show error message in the username field if user enters invalid username
                binding.editTextTextUserName.error = getString(R.string.username_error)
            } else if (!validator.isValidPassword(password)) {
                // 5) Show error message in the password field if user enters invalid password
                binding.editTextTextPassword.error = getString(R.string.password_error)
            } else {
                doLogin(username, password)
            }

        }
    }

    // 1) Enable submit button only when user enters valid username and password
    private fun enableSubmitButton(username: String?, password: String?) {
        binding.submitButton.isEnabled = username!!.length > 8 && password!!.length > 8
    }


    private fun doLogin(username: String?, password: String?) {
        if (username!!.equals(Validator.TestData.getUserName()) && password!!.equals(Validator.TestData.getPassword())) {
            // 2) show success message to the user upon submitting username and password as “testusername” and “testPassword1”
            Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show()
        } else {
            // 3) Show failure message if user enters valid username and password but not username and password as “testusername” and “testPassword1”
            Toast.makeText(this, getString(R.string.login_failed), Toast.LENGTH_SHORT)
                .show()
        }
    }


}