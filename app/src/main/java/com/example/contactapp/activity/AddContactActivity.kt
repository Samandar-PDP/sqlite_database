package com.example.contactapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactapp.R
import com.example.contactapp.database.MyDatabase
import com.example.contactapp.databinding.ActivityAddContactBinding
import com.example.contactapp.model.Contact
import com.example.contactapp.util.snack
import com.google.android.material.snackbar.Snackbar

class AddContactActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddContactBinding.inflate(layoutInflater) }
    private lateinit var myDatabase: MyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.add_con)
        myDatabase = MyDatabase(this)

        binding.btnAddContact.setOnClickListener {
            val email = binding.editName.text.toString().trim()
            val number = binding.editNumber.text.toString().trim()
            if (email.isNotBlank() && number.isNotBlank()) {
                myDatabase.addContact(Contact(email, number))
                    snack(it, "Successfully saved!")
            } else {
                snack(it, "Enter data!")
            }
        }
    }
}