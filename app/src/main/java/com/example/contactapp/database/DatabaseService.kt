package com.example.contactapp.database

import com.example.contactapp.model.Contact

interface DatabaseService {
    fun addContact(contact: Contact)
    fun getAllContacts(): List<Contact>
    fun deleteContact(contact: Contact)
    fun updateContact(contact: Contact)
    fun getContactById(id: Int): Contact
    fun deleteAllContacts()
}