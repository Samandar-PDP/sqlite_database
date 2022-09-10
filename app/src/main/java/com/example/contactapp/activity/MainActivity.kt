package com.example.contactapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactapp.R
import com.example.contactapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.main_activity)
        binding.btnAddContact.setOnClickListener {
            startActivity(Intent(this, AddContactActivity::class.java))
        }
        binding.btnContactList.setOnClickListener {
            startActivity(Intent(this, AllContactActivity::class.java))
        }
    }
}