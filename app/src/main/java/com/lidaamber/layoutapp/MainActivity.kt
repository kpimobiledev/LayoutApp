package com.lidaamber.layoutapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.change_button as changeButton
import kotlinx.android.synthetic.main.activity_main.name_edit_text as nameEditText
import kotlinx.android.synthetic.main.activity_main.name_text_view as nameTextView
import kotlinx.android.synthetic.main.activity_main.surname_edit_text as surnameEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val surname = surnameEditText.text.toString()

            nameTextView.text = name

            Toast.makeText(
                this,
                getString(R.string.name_pattern, name, surname),
                Toast.LENGTH_LONG
            ).show()
        }
    }

}