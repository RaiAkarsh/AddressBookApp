package com.AddressBookApp.model;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private List<ContactPerson> contacts = new ArrayList<>();

    public List<ContactPerson> getContacts() {
        return contacts;
    }
}