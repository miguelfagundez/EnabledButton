package com.devproject.miguelfagundez.enablebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    // Views
    lateinit var editTextUsername : EditText
    lateinit var editTextPassword : EditText
    lateinit var button : Button

    // Variables
    var usernameEnabled : Boolean = false
    var passwordEnabled : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        editTextUsername = findViewById(R.id.editTextTop)
        editTextPassword = findViewById(R.id.editTextBottom)
        button = findViewById(R.id.button)
    }

    private fun setupListeners() {
        editTextUsername.addTextChangedListener {username ->
            var text : String? = username?.toString()?.trim()
            text?.let {
                usernameEnabled = !it.isNullOrEmpty()
                button.isEnabled = usernameEnabled && passwordEnabled
            }
        }
        editTextPassword.addTextChangedListener {password ->
            var text : String? = password?.toString()?.trim()
            text?.let {
                passwordEnabled = !it.isNullOrEmpty()
                button.isEnabled = usernameEnabled && passwordEnabled
            }
        }
    }
}