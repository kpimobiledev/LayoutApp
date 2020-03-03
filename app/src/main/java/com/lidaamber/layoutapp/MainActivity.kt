package com.lidaamber.layoutapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lidaamber.layoutapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var person = Person("John", "Smith")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.person = person

        binding.changeButton.setOnClickListener {
            updatePerson()

            Toast.makeText(
                this,
                getString(R.string.name_pattern, person.name, person.surname),
                Toast.LENGTH_LONG
            ).show()

        }
    }

    private fun updatePerson() {
        binding.apply {
            person?.name = nameEditText.text.toString()
            person?.surname = surnameEditText.text.toString()

            invalidateAll()
        }
    }
}

data class Person(var name: String, var surname: String)