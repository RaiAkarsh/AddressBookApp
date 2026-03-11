package com.AddressBookApp.service;

import com.AddressBookApp.model.AddressBook;
import com.AddressBookApp.model.ContactPerson;

public class AddressBookService {

    AddressBook addressBook = new AddressBook();

    public void addContact(ContactPerson person) {
        addressBook.getContacts().add(person);
    }

    public void displayContacts() {

        for (ContactPerson person : addressBook.getContacts()) {
            person.display();
            System.out.println("--------------------");
        }
    }
}