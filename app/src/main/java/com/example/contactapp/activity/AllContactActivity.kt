package com.example.contactapp.activity

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactapp.R
import com.example.contactapp.adapter.ContactAdapter
import com.example.contactapp.database.MyDatabase
import com.example.contactapp.databinding.ActivityAllContactBinding
import com.example.contactapp.util.snack

class AllContactActivity : AppCompatActivity() {
    private lateinit var myDatabase: MyDatabase
    private lateinit var contactAdapter: ContactAdapter
    private val binding by lazy { ActivityAllContactBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.all_con)
        myDatabase = MyDatabase(this)
        contactAdapter = ContactAdapter()
        contactAdapter.contactList = myDatabase.getAllContacts()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@AllContactActivity)
            adapter = contactAdapter
        }
        contactAdapter.onDeleteClick = { contact, pos ->
            AlertDialog.Builder(this).apply {
                setTitle("Delete")
                setMessage("Do you want to delete this contact?")
                setNegativeButton("No", null)
                setPositiveButton("Yes") { _, _ ->
                    snack(binding.root, "Successfully deleted!")
                    contactAdapter.notifyItemRemoved(pos)
                    contactAdapter.contactList.removeAt(pos)
                    myDatabase.deleteContact(contact)
                }
            }.create().show()
        }
    }
}